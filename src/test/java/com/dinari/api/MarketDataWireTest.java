package com.dinari.api;

import com.dinari.api.core.ObjectMappers;
import com.dinari.api.errors.UnprocessableEntityError;
import com.dinari.api.resources.marketdata.requests.GetAlloyCurrentPriceRequest;
import com.dinari.api.resources.marketdata.requests.GetAlloyPriceChartRequest;
import com.dinari.api.resources.marketdata.requests.GetAlloysRequest;
import com.dinari.api.resources.marketdata.requests.GetStockCurrentPriceRequest;
import com.dinari.api.resources.marketdata.requests.GetStockCurrentQuotesRouteV2Request;
import com.dinari.api.resources.marketdata.requests.GetStockNewsByStockIdRequest;
import com.dinari.api.resources.marketdata.requests.GetStockPriceChartRequest;
import com.dinari.api.resources.marketdata.requests.GetStocksRequest;
import com.dinari.api.resources.marketdata.types.GetAlloyPriceChartRequestTimespan;
import com.dinari.api.resources.marketdata.types.GetStocksResponse;
import com.dinari.api.types.AlloyHistoricalPriceDataPointV1;
import com.dinari.api.types.AlloyPriceV1;
import com.dinari.api.types.ExtendedMarketHours;
import com.dinari.api.types.PaginatedAlloyResponseV1;
import com.dinari.api.types.StockNewsArticleInfo;
import com.dinari.api.types.StockPrice;
import com.dinari.api.types.StockQuoteResponseOneOfSchema;
import com.dinari.api.types.StockTickTimespan1;
import com.dinari.api.types.StocksHistoricalPriceDataPoint;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MarketDataWireTest {
    private MockWebServer server;
    private DinariClient client;
    private ObjectMapper objectMapper = ObjectMappers.JSON_MAPPER;

    @BeforeEach
    public void setup() throws Exception {
        server = new MockWebServer();
        server.start();
        client = DinariClient.builder()
                .url(server.url("/").toString())
                .maxRetries(0)
                .apiKeyId("test-api-key")
                .apiSecretKey("test-apiSecretKey")
                .build();
    }

    @AfterEach
    public void teardown() throws Exception {
        server.shutdown();
    }

    @Test
    public void testGetAlloys() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"_sv\":\"PaginatedAlloyResponse:v1\",\"data\":[{\"_sv\":\"Alloy:v1\",\"id\":\"id\",\"name\":\"name\",\"symbol\":\"symbol\",\"is_tradable\":true}],\"pagination_metadata\":{\"previous\":\"previous\",\"next\":\"next\"}}"));
        PaginatedAlloyResponseV1 response =
                client.marketData().getAlloys(GetAlloysRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"_sv\": \"PaginatedAlloyResponse:v1\",\n"
                + "  \"data\": [\n"
                + "    {\n"
                + "      \"_sv\": \"Alloy:v1\",\n"
                + "      \"id\": \"id\",\n"
                + "      \"name\": \"name\",\n"
                + "      \"symbol\": \"symbol\",\n"
                + "      \"is_tradable\": true\n"
                + "    }\n"
                + "  ],\n"
                + "  \"pagination_metadata\": {\n"
                + "    \"previous\": \"previous\",\n"
                + "    \"next\": \"next\"\n"
                + "  }\n"
                + "}";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertTrue(
                jsonEquals(expectedResponseNode, actualResponseNode),
                "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testGetAlloysThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.marketData()
                        .getAlloys(GetAlloysRequest.builder().build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate error response
        Assertions.assertEquals(422, exception.statusCode(), "Error status code does not match expected");
        String actualErrorJson = objectMapper.writeValueAsString(exception.body());
        String expectedErrorBody = ""
                + "{\n"
                + "  \"error_id\": \"error_id\",\n"
                + "  \"error\": {\n"
                + "    \"field_errors\": [\n"
                + "      {\n"
                + "        \"field_name\": \"field_name\",\n"
                + "        \"field_error\": \"field_error\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"field_name\": \"field_name\",\n"
                + "        \"field_error\": \"field_error\"\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}";
        JsonNode actualErrorNode = objectMapper.readTree(actualErrorJson);
        JsonNode expectedErrorNode = objectMapper.readTree(expectedErrorBody);
        Assertions.assertTrue(jsonEquals(expectedErrorNode, actualErrorNode), "Error body does not match expected");
    }

    @Test
    public void testGetAlloyCurrentPrice() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"_sv\":\"AlloyPrice:v1\",\"id\":\"id\",\"price\":\"price\",\"timestamp\":\"2024-01-15T09:30:00Z\"}"));
        AlloyPriceV1 response = client.marketData()
                .getAlloyCurrentPrice(GetAlloyCurrentPriceRequest.builder()
                        .alloyId("alloy_id")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"_sv\": \"AlloyPrice:v1\",\n"
                + "  \"id\": \"id\",\n"
                + "  \"price\": \"price\",\n"
                + "  \"timestamp\": \"2024-01-15T09:30:00Z\"\n"
                + "}";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertTrue(
                jsonEquals(expectedResponseNode, actualResponseNode),
                "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testGetAlloyPriceChart() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"_sv\":\"AlloyHistoricalPriceDataPointV1:v1\",\"timestamp\":1,\"open\":1.1,\"close\":1.1,\"high\":1.1,\"low\":1.1}]"));
        List<AlloyHistoricalPriceDataPointV1> response = client.marketData()
                .getAlloyPriceChart(GetAlloyPriceChartRequest.builder()
                        .alloyId("alloy_id")
                        .timespan(GetAlloyPriceChartRequestTimespan.DAY)
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "[\n"
                + "  {\n"
                + "    \"_sv\": \"AlloyHistoricalPriceDataPointV1:v1\",\n"
                + "    \"timestamp\": 1,\n"
                + "    \"open\": 1.1,\n"
                + "    \"close\": 1.1,\n"
                + "    \"high\": 1.1,\n"
                + "    \"low\": 1.1\n"
                + "  }\n"
                + "]";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertTrue(
                jsonEquals(expectedResponseNode, actualResponseNode),
                "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testGetAlloyPriceChartThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.marketData()
                        .getAlloyPriceChart(GetAlloyPriceChartRequest.builder()
                                .alloyId("alloy_id")
                                .timespan(GetAlloyPriceChartRequestTimespan.DAY)
                                .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate error response
        Assertions.assertEquals(422, exception.statusCode(), "Error status code does not match expected");
        String actualErrorJson = objectMapper.writeValueAsString(exception.body());
        String expectedErrorBody = ""
                + "{\n"
                + "  \"error_id\": \"error_id\",\n"
                + "  \"error\": {\n"
                + "    \"field_errors\": [\n"
                + "      {\n"
                + "        \"field_name\": \"field_name\",\n"
                + "        \"field_error\": \"field_error\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"field_name\": \"field_name\",\n"
                + "        \"field_error\": \"field_error\"\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}";
        JsonNode actualErrorNode = objectMapper.readTree(actualErrorJson);
        JsonNode expectedErrorNode = objectMapper.readTree(expectedErrorBody);
        Assertions.assertTrue(jsonEquals(expectedErrorNode, actualErrorNode), "Error body does not match expected");
    }

    @Test
    public void testGetStocks() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"id\":\"id\",\"name\":\"name\",\"symbol\":\"symbol\",\"is_fractionable\":true,\"is_tradable\":true,\"tokens\":[\"tokens\"],\"composite_figi\":\"composite_figi\",\"cusip\":\"cusip\",\"cik\":\"cik\",\"display_name\":\"display_name\",\"description\":\"description\",\"logo_url\":\"logo_url\"}]"));
        GetStocksResponse response =
                client.marketData().getStocks(GetStocksRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "[\n"
                + "  {\n"
                + "    \"id\": \"id\",\n"
                + "    \"name\": \"name\",\n"
                + "    \"symbol\": \"symbol\",\n"
                + "    \"is_fractionable\": true,\n"
                + "    \"is_tradable\": true,\n"
                + "    \"tokens\": [\n"
                + "      \"tokens\"\n"
                + "    ],\n"
                + "    \"composite_figi\": \"composite_figi\",\n"
                + "    \"cusip\": \"cusip\",\n"
                + "    \"cik\": \"cik\",\n"
                + "    \"display_name\": \"display_name\",\n"
                + "    \"description\": \"description\",\n"
                + "    \"logo_url\": \"logo_url\"\n"
                + "  }\n"
                + "]";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertTrue(
                jsonEquals(expectedResponseNode, actualResponseNode),
                "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testGetStocksThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.marketData()
                        .getStocks(GetStocksRequest.builder().build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate error response
        Assertions.assertEquals(422, exception.statusCode(), "Error status code does not match expected");
        String actualErrorJson = objectMapper.writeValueAsString(exception.body());
        String expectedErrorBody = ""
                + "{\n"
                + "  \"error_id\": \"error_id\",\n"
                + "  \"error\": {\n"
                + "    \"field_errors\": [\n"
                + "      {\n"
                + "        \"field_name\": \"field_name\",\n"
                + "        \"field_error\": \"field_error\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"field_name\": \"field_name\",\n"
                + "        \"field_error\": \"field_error\"\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}";
        JsonNode actualErrorNode = objectMapper.readTree(actualErrorJson);
        JsonNode expectedErrorNode = objectMapper.readTree(expectedErrorBody);
        Assertions.assertTrue(jsonEquals(expectedErrorNode, actualErrorNode), "Error body does not match expected");
    }

    @Test
    public void testGetStockCurrentPrice() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"stock_id\":\"stock_id\",\"price\":1.1,\"timestamp\":\"2024-01-15T09:30:00Z\",\"market_cap\":1,\"weighted_shares_outstanding\":1,\"change\":1.1,\"change_percent\":1.1,\"previous_close\":1.1,\"close\":1.1,\"high\":1.1,\"low\":1.1,\"open\":1.1,\"volume\":1.1,\"last\":1.1}"));
        StockPrice response = client.marketData()
                .getStockCurrentPrice(GetStockCurrentPriceRequest.builder()
                        .stockId("stock_id")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"stock_id\": \"stock_id\",\n"
                + "  \"price\": 1.1,\n"
                + "  \"timestamp\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"market_cap\": 1,\n"
                + "  \"weighted_shares_outstanding\": 1,\n"
                + "  \"change\": 1.1,\n"
                + "  \"change_percent\": 1.1,\n"
                + "  \"previous_close\": 1.1,\n"
                + "  \"close\": 1.1,\n"
                + "  \"high\": 1.1,\n"
                + "  \"low\": 1.1,\n"
                + "  \"open\": 1.1,\n"
                + "  \"volume\": 1.1,\n"
                + "  \"last\": 1.1\n"
                + "}";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertTrue(
                jsonEquals(expectedResponseNode, actualResponseNode),
                "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testGetStockCurrentQuotesRouteV2() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"stock_id\":\"stock_id\",\"ask_price\":1.1,\"ask_size\":1.1,\"bid_price\":1.1,\"bid_size\":1.1,\"timestamp\":\"2024-01-15T09:30:00Z\",\"_sv\":\"StockQuote:v1\"}"));
        StockQuoteResponseOneOfSchema response = client.marketData()
                .getStockCurrentQuotesRouteV2(GetStockCurrentQuotesRouteV2Request.builder()
                        .stockId("stock_id")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"stock_id\": \"stock_id\",\n"
                + "  \"ask_price\": 1.1,\n"
                + "  \"ask_size\": 1.1,\n"
                + "  \"bid_price\": 1.1,\n"
                + "  \"bid_size\": 1.1,\n"
                + "  \"timestamp\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"_sv\": \"StockQuote:v1\"\n"
                + "}";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertTrue(
                jsonEquals(expectedResponseNode, actualResponseNode),
                "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testGetStockCurrentQuotesRouteV2ThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.marketData()
                        .getStockCurrentQuotesRouteV2(GetStockCurrentQuotesRouteV2Request.builder()
                                .stockId("stock_id")
                                .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate error response
        Assertions.assertEquals(422, exception.statusCode(), "Error status code does not match expected");
        String actualErrorJson = objectMapper.writeValueAsString(exception.body());
        String expectedErrorBody = ""
                + "{\n"
                + "  \"error_id\": \"error_id\",\n"
                + "  \"error\": {\n"
                + "    \"field_errors\": [\n"
                + "      {\n"
                + "        \"field_name\": \"field_name\",\n"
                + "        \"field_error\": \"field_error\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"field_name\": \"field_name\",\n"
                + "        \"field_error\": \"field_error\"\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}";
        JsonNode actualErrorNode = objectMapper.readTree(actualErrorJson);
        JsonNode expectedErrorNode = objectMapper.readTree(expectedErrorBody);
        Assertions.assertTrue(jsonEquals(expectedErrorNode, actualErrorNode), "Error body does not match expected");
    }

    @Test
    public void testGetStockPriceChart() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("[{\"timestamp\":1,\"open\":1.1,\"close\":1.1,\"high\":1.1,\"low\":1.1}]"));
        List<StocksHistoricalPriceDataPoint> response = client.marketData()
                .getStockPriceChart(GetStockPriceChartRequest.builder()
                        .stockId("stock_id")
                        .timespan(StockTickTimespan1.DAY)
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "[\n"
                + "  {\n"
                + "    \"timestamp\": 1,\n"
                + "    \"open\": 1.1,\n"
                + "    \"close\": 1.1,\n"
                + "    \"high\": 1.1,\n"
                + "    \"low\": 1.1\n"
                + "  }\n"
                + "]";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertTrue(
                jsonEquals(expectedResponseNode, actualResponseNode),
                "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testGetStockPriceChartThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.marketData()
                        .getStockPriceChart(GetStockPriceChartRequest.builder()
                                .stockId("stock_id")
                                .timespan(StockTickTimespan1.DAY)
                                .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate error response
        Assertions.assertEquals(422, exception.statusCode(), "Error status code does not match expected");
        String actualErrorJson = objectMapper.writeValueAsString(exception.body());
        String expectedErrorBody = ""
                + "{\n"
                + "  \"error_id\": \"error_id\",\n"
                + "  \"error\": {\n"
                + "    \"field_errors\": [\n"
                + "      {\n"
                + "        \"field_name\": \"field_name\",\n"
                + "        \"field_error\": \"field_error\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"field_name\": \"field_name\",\n"
                + "        \"field_error\": \"field_error\"\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}";
        JsonNode actualErrorNode = objectMapper.readTree(actualErrorJson);
        JsonNode expectedErrorNode = objectMapper.readTree(expectedErrorBody);
        Assertions.assertTrue(jsonEquals(expectedErrorNode, actualErrorNode), "Error body does not match expected");
    }

    @Test
    public void testGetStockNewsByStockId() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"article_url\":\"article_url\",\"description\":\"description\",\"image_url\":\"image_url\",\"published_dt\":\"2024-01-15T09:30:00Z\",\"publisher\":\"publisher\",\"amp_url\":\"amp_url\"}]"));
        List<StockNewsArticleInfo> response = client.marketData()
                .getStockNewsByStockId(GetStockNewsByStockIdRequest.builder()
                        .stockId("stock_id")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "[\n"
                + "  {\n"
                + "    \"article_url\": \"article_url\",\n"
                + "    \"description\": \"description\",\n"
                + "    \"image_url\": \"image_url\",\n"
                + "    \"published_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "    \"publisher\": \"publisher\",\n"
                + "    \"amp_url\": \"amp_url\"\n"
                + "  }\n"
                + "]";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertTrue(
                jsonEquals(expectedResponseNode, actualResponseNode),
                "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testGetStockNewsByStockIdThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.marketData()
                        .getStockNewsByStockId(GetStockNewsByStockIdRequest.builder()
                                .stockId("stock_id")
                                .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate error response
        Assertions.assertEquals(422, exception.statusCode(), "Error status code does not match expected");
        String actualErrorJson = objectMapper.writeValueAsString(exception.body());
        String expectedErrorBody = ""
                + "{\n"
                + "  \"error_id\": \"error_id\",\n"
                + "  \"error\": {\n"
                + "    \"field_errors\": [\n"
                + "      {\n"
                + "        \"field_name\": \"field_name\",\n"
                + "        \"field_error\": \"field_error\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"field_name\": \"field_name\",\n"
                + "        \"field_error\": \"field_error\"\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}";
        JsonNode actualErrorNode = objectMapper.readTree(actualErrorJson);
        JsonNode expectedErrorNode = objectMapper.readTree(expectedErrorBody);
        Assertions.assertTrue(jsonEquals(expectedErrorNode, actualErrorNode), "Error body does not match expected");
    }

    @Test
    public void testGetMarketHours() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"is_market_open\":true,\"next_session_open_dt\":\"2024-01-15T09:30:00Z\",\"next_session_close_dt\":\"2024-01-15T09:30:00Z\",\"next_session_overnight_open_time_dt\":\"2024-01-15T09:30:00Z\",\"next_session_pre_market_open_time_dt\":\"2024-01-15T09:30:00Z\",\"next_session_after_hours_close_time_dt\":\"2024-01-15T09:30:00Z\",\"current_session_open_dt\":\"2024-01-15T09:30:00Z\",\"current_session_close_dt\":\"2024-01-15T09:30:00Z\",\"current_session_overnight_open_time_dt\":\"2024-01-15T09:30:00Z\",\"current_session_pre_market_open_time_dt\":\"2024-01-15T09:30:00Z\",\"current_session_after_hours_close_time_dt\":\"2024-01-15T09:30:00Z\"}"));
        ExtendedMarketHours response = client.marketData().getMarketHours();
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"is_market_open\": true,\n"
                + "  \"next_session_open_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"next_session_close_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"next_session_overnight_open_time_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"next_session_pre_market_open_time_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"next_session_after_hours_close_time_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"current_session_open_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"current_session_close_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"current_session_overnight_open_time_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"current_session_pre_market_open_time_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"current_session_after_hours_close_time_dt\": \"2024-01-15T09:30:00Z\"\n"
                + "}";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertTrue(
                jsonEquals(expectedResponseNode, actualResponseNode),
                "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    /**
     * Compares two JsonNodes with numeric equivalence and null safety.
     * For objects, checks that all fields in 'expected' exist in 'actual' with matching values.
     * Allows 'actual' to have extra fields (e.g., default values added during serialization).
     */
    private boolean jsonEquals(JsonNode expected, JsonNode actual) {
        if (expected == null && actual == null) return true;
        if (expected == null || actual == null) return false;
        if (expected.equals(actual)) return true;
        if (expected.isNumber() && actual.isNumber())
            return Math.abs(expected.doubleValue() - actual.doubleValue()) < 1e-10;
        if (expected.isObject() && actual.isObject()) {
            java.util.Iterator<java.util.Map.Entry<String, JsonNode>> iter = expected.fields();
            while (iter.hasNext()) {
                java.util.Map.Entry<String, JsonNode> entry = iter.next();
                JsonNode actualValue = actual.get(entry.getKey());
                if (actualValue == null) {
                    if (!entry.getValue().isNull()) return false;
                } else if (!jsonEquals(entry.getValue(), actualValue)) return false;
            }
            return true;
        }
        if (expected.isArray() && actual.isArray()) {
            if (expected.size() != actual.size()) return false;
            for (int i = 0; i < expected.size(); i++) {
                if (!jsonEquals(expected.get(i), actual.get(i))) return false;
            }
            return true;
        }
        return false;
    }
}
