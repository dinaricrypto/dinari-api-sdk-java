package com.dinari.api;

import com.dinari.api.core.ObjectMappers;
import com.dinari.api.errors.LockedError;
import com.dinari.api.errors.UnprocessableEntityError;
import com.dinari.api.resources.managedorders.requests.CreateLimitOrderBuyRequestInput;
import com.dinari.api.resources.managedorders.requests.CreateLimitOrderSellRequestInput;
import com.dinari.api.resources.managedorders.requests.CreateMarketBuyOrderRequestInput;
import com.dinari.api.resources.managedorders.requests.CreateMarketSellOrderRequestInput;
import com.dinari.api.types.OrderRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagedOrdersWireTest {
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
    public void testCreateMarketBuyManagedOrderRequest() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(201)
                        .setBody(
                                "{\"id\":\"id\",\"account_id\":\"account_id\",\"status\":\"QUOTED\",\"created_dt\":\"2024-01-15T09:30:00Z\",\"order_side\":\"BUY\",\"order_type\":\"MARKET\",\"order_tif\":\"DAY\",\"recipient_account_id\":\"recipient_account_id\",\"order_id\":\"order_id\",\"client_order_id\":\"client_order_id\",\"cancel_message\":\"cancel_message\",\"reject_message\":\"reject_message\"}"));
        OrderRequest response = client.managedOrders()
                .createMarketBuyManagedOrderRequest(CreateMarketBuyOrderRequestInput.builder()
                        .accountId("account_id")
                        .paymentAmount(1.1)
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"payment_amount\": 1.1\n" + "}";
        JsonNode actualJson = objectMapper.readTree(actualRequestBody);
        JsonNode expectedJson = objectMapper.readTree(expectedRequestBody);
        Assertions.assertTrue(jsonEquals(expectedJson, actualJson), "Request body structure does not match expected");
        if (actualJson.has("type") || actualJson.has("_type") || actualJson.has("kind")) {
            String discriminator = null;
            if (actualJson.has("type")) discriminator = actualJson.get("type").asText();
            else if (actualJson.has("_type"))
                discriminator = actualJson.get("_type").asText();
            else if (actualJson.has("kind"))
                discriminator = actualJson.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualJson.isNull()) {
            Assertions.assertTrue(
                    actualJson.isObject() || actualJson.isArray() || actualJson.isValueNode(),
                    "request should be a valid JSON value");
        }

        if (actualJson.isArray()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Array should have valid size");
        }
        if (actualJson.isObject()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Object should have valid field count");
        }

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"id\": \"id\",\n"
                + "  \"account_id\": \"account_id\",\n"
                + "  \"status\": \"QUOTED\",\n"
                + "  \"created_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"order_side\": \"BUY\",\n"
                + "  \"order_type\": \"MARKET\",\n"
                + "  \"order_tif\": \"DAY\",\n"
                + "  \"recipient_account_id\": \"recipient_account_id\",\n"
                + "  \"order_id\": \"order_id\",\n"
                + "  \"client_order_id\": \"client_order_id\",\n"
                + "  \"cancel_message\": \"cancel_message\",\n"
                + "  \"reject_message\": \"reject_message\"\n"
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
    public void testCreateMarketBuyManagedOrderRequestThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.managedOrders()
                        .createMarketBuyManagedOrderRequest(CreateMarketBuyOrderRequestInput.builder()
                                .accountId("account_id")
                                .paymentAmount(1.1)
                                .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"payment_amount\": 1.1\n" + "}";
        JsonNode actualJson = objectMapper.readTree(actualRequestBody);
        JsonNode expectedJson = objectMapper.readTree(expectedRequestBody);
        Assertions.assertTrue(jsonEquals(expectedJson, actualJson), "Request body structure does not match expected");
        if (actualJson.has("type") || actualJson.has("_type") || actualJson.has("kind")) {
            String discriminator = null;
            if (actualJson.has("type")) discriminator = actualJson.get("type").asText();
            else if (actualJson.has("_type"))
                discriminator = actualJson.get("_type").asText();
            else if (actualJson.has("kind"))
                discriminator = actualJson.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualJson.isNull()) {
            Assertions.assertTrue(
                    actualJson.isObject() || actualJson.isArray() || actualJson.isValueNode(),
                    "request should be a valid JSON value");
        }

        if (actualJson.isArray()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Array should have valid size");
        }
        if (actualJson.isObject()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Object should have valid field count");
        }

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
    public void testCreateMarketBuyManagedOrderRequestThrowsLockedError() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(423)
                .setBody("{\"status\":1,\"message\":\"message\",\"error_id\":\"error_id\"}"));
        LockedError exception = Assertions.assertThrows(LockedError.class, () -> client.managedOrders()
                .createMarketBuyManagedOrderRequest(CreateMarketBuyOrderRequestInput.builder()
                        .accountId("account_id")
                        .paymentAmount(1.1)
                        .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"payment_amount\": 1.1\n" + "}";
        JsonNode actualJson = objectMapper.readTree(actualRequestBody);
        JsonNode expectedJson = objectMapper.readTree(expectedRequestBody);
        Assertions.assertTrue(jsonEquals(expectedJson, actualJson), "Request body structure does not match expected");
        if (actualJson.has("type") || actualJson.has("_type") || actualJson.has("kind")) {
            String discriminator = null;
            if (actualJson.has("type")) discriminator = actualJson.get("type").asText();
            else if (actualJson.has("_type"))
                discriminator = actualJson.get("_type").asText();
            else if (actualJson.has("kind"))
                discriminator = actualJson.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualJson.isNull()) {
            Assertions.assertTrue(
                    actualJson.isObject() || actualJson.isArray() || actualJson.isValueNode(),
                    "request should be a valid JSON value");
        }

        if (actualJson.isArray()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Array should have valid size");
        }
        if (actualJson.isObject()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Object should have valid field count");
        }

        // Validate error response
        Assertions.assertEquals(423, exception.statusCode(), "Error status code does not match expected");
        String actualErrorJson = objectMapper.writeValueAsString(exception.body());
        String expectedErrorBody = ""
                + "{\n"
                + "  \"status\": 1,\n"
                + "  \"message\": \"message\",\n"
                + "  \"error_id\": \"error_id\"\n"
                + "}";
        JsonNode actualErrorNode = objectMapper.readTree(actualErrorJson);
        JsonNode expectedErrorNode = objectMapper.readTree(expectedErrorBody);
        Assertions.assertTrue(jsonEquals(expectedErrorNode, actualErrorNode), "Error body does not match expected");
    }

    @Test
    public void testCreateMarketSellManagedOrderRequest() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(201)
                        .setBody(
                                "{\"id\":\"id\",\"account_id\":\"account_id\",\"status\":\"QUOTED\",\"created_dt\":\"2024-01-15T09:30:00Z\",\"order_side\":\"BUY\",\"order_type\":\"MARKET\",\"order_tif\":\"DAY\",\"recipient_account_id\":\"recipient_account_id\",\"order_id\":\"order_id\",\"client_order_id\":\"client_order_id\",\"cancel_message\":\"cancel_message\",\"reject_message\":\"reject_message\"}"));
        OrderRequest response = client.managedOrders()
                .createMarketSellManagedOrderRequest(CreateMarketSellOrderRequestInput.builder()
                        .accountId("account_id")
                        .assetQuantity(1.1)
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"asset_quantity\": 1.1\n" + "}";
        JsonNode actualJson = objectMapper.readTree(actualRequestBody);
        JsonNode expectedJson = objectMapper.readTree(expectedRequestBody);
        Assertions.assertTrue(jsonEquals(expectedJson, actualJson), "Request body structure does not match expected");
        if (actualJson.has("type") || actualJson.has("_type") || actualJson.has("kind")) {
            String discriminator = null;
            if (actualJson.has("type")) discriminator = actualJson.get("type").asText();
            else if (actualJson.has("_type"))
                discriminator = actualJson.get("_type").asText();
            else if (actualJson.has("kind"))
                discriminator = actualJson.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualJson.isNull()) {
            Assertions.assertTrue(
                    actualJson.isObject() || actualJson.isArray() || actualJson.isValueNode(),
                    "request should be a valid JSON value");
        }

        if (actualJson.isArray()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Array should have valid size");
        }
        if (actualJson.isObject()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Object should have valid field count");
        }

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"id\": \"id\",\n"
                + "  \"account_id\": \"account_id\",\n"
                + "  \"status\": \"QUOTED\",\n"
                + "  \"created_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"order_side\": \"BUY\",\n"
                + "  \"order_type\": \"MARKET\",\n"
                + "  \"order_tif\": \"DAY\",\n"
                + "  \"recipient_account_id\": \"recipient_account_id\",\n"
                + "  \"order_id\": \"order_id\",\n"
                + "  \"client_order_id\": \"client_order_id\",\n"
                + "  \"cancel_message\": \"cancel_message\",\n"
                + "  \"reject_message\": \"reject_message\"\n"
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
    public void testCreateMarketSellManagedOrderRequestThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.managedOrders()
                        .createMarketSellManagedOrderRequest(CreateMarketSellOrderRequestInput.builder()
                                .accountId("account_id")
                                .assetQuantity(1.1)
                                .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"asset_quantity\": 1.1\n" + "}";
        JsonNode actualJson = objectMapper.readTree(actualRequestBody);
        JsonNode expectedJson = objectMapper.readTree(expectedRequestBody);
        Assertions.assertTrue(jsonEquals(expectedJson, actualJson), "Request body structure does not match expected");
        if (actualJson.has("type") || actualJson.has("_type") || actualJson.has("kind")) {
            String discriminator = null;
            if (actualJson.has("type")) discriminator = actualJson.get("type").asText();
            else if (actualJson.has("_type"))
                discriminator = actualJson.get("_type").asText();
            else if (actualJson.has("kind"))
                discriminator = actualJson.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualJson.isNull()) {
            Assertions.assertTrue(
                    actualJson.isObject() || actualJson.isArray() || actualJson.isValueNode(),
                    "request should be a valid JSON value");
        }

        if (actualJson.isArray()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Array should have valid size");
        }
        if (actualJson.isObject()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Object should have valid field count");
        }

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
    public void testCreateMarketSellManagedOrderRequestThrowsLockedError() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(423)
                .setBody("{\"status\":1,\"message\":\"message\",\"error_id\":\"error_id\"}"));
        LockedError exception = Assertions.assertThrows(LockedError.class, () -> client.managedOrders()
                .createMarketSellManagedOrderRequest(CreateMarketSellOrderRequestInput.builder()
                        .accountId("account_id")
                        .assetQuantity(1.1)
                        .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"asset_quantity\": 1.1\n" + "}";
        JsonNode actualJson = objectMapper.readTree(actualRequestBody);
        JsonNode expectedJson = objectMapper.readTree(expectedRequestBody);
        Assertions.assertTrue(jsonEquals(expectedJson, actualJson), "Request body structure does not match expected");
        if (actualJson.has("type") || actualJson.has("_type") || actualJson.has("kind")) {
            String discriminator = null;
            if (actualJson.has("type")) discriminator = actualJson.get("type").asText();
            else if (actualJson.has("_type"))
                discriminator = actualJson.get("_type").asText();
            else if (actualJson.has("kind"))
                discriminator = actualJson.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualJson.isNull()) {
            Assertions.assertTrue(
                    actualJson.isObject() || actualJson.isArray() || actualJson.isValueNode(),
                    "request should be a valid JSON value");
        }

        if (actualJson.isArray()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Array should have valid size");
        }
        if (actualJson.isObject()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Object should have valid field count");
        }

        // Validate error response
        Assertions.assertEquals(423, exception.statusCode(), "Error status code does not match expected");
        String actualErrorJson = objectMapper.writeValueAsString(exception.body());
        String expectedErrorBody = ""
                + "{\n"
                + "  \"status\": 1,\n"
                + "  \"message\": \"message\",\n"
                + "  \"error_id\": \"error_id\"\n"
                + "}";
        JsonNode actualErrorNode = objectMapper.readTree(actualErrorJson);
        JsonNode expectedErrorNode = objectMapper.readTree(expectedErrorBody);
        Assertions.assertTrue(jsonEquals(expectedErrorNode, actualErrorNode), "Error body does not match expected");
    }

    @Test
    public void testCreateLimitBuyManagedOrderRequest() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(201)
                        .setBody(
                                "{\"id\":\"id\",\"account_id\":\"account_id\",\"status\":\"QUOTED\",\"created_dt\":\"2024-01-15T09:30:00Z\",\"order_side\":\"BUY\",\"order_type\":\"MARKET\",\"order_tif\":\"DAY\",\"recipient_account_id\":\"recipient_account_id\",\"order_id\":\"order_id\",\"client_order_id\":\"client_order_id\",\"cancel_message\":\"cancel_message\",\"reject_message\":\"reject_message\"}"));
        OrderRequest response = client.managedOrders()
                .createLimitBuyManagedOrderRequest(CreateLimitOrderBuyRequestInput.builder()
                        .accountId("account_id")
                        .assetQuantity(1.1)
                        .limitPrice(1.1)
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"asset_quantity\": 1.1,\n" + "  \"limit_price\": 1.1\n" + "}";
        JsonNode actualJson = objectMapper.readTree(actualRequestBody);
        JsonNode expectedJson = objectMapper.readTree(expectedRequestBody);
        Assertions.assertTrue(jsonEquals(expectedJson, actualJson), "Request body structure does not match expected");
        if (actualJson.has("type") || actualJson.has("_type") || actualJson.has("kind")) {
            String discriminator = null;
            if (actualJson.has("type")) discriminator = actualJson.get("type").asText();
            else if (actualJson.has("_type"))
                discriminator = actualJson.get("_type").asText();
            else if (actualJson.has("kind"))
                discriminator = actualJson.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualJson.isNull()) {
            Assertions.assertTrue(
                    actualJson.isObject() || actualJson.isArray() || actualJson.isValueNode(),
                    "request should be a valid JSON value");
        }

        if (actualJson.isArray()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Array should have valid size");
        }
        if (actualJson.isObject()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Object should have valid field count");
        }

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"id\": \"id\",\n"
                + "  \"account_id\": \"account_id\",\n"
                + "  \"status\": \"QUOTED\",\n"
                + "  \"created_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"order_side\": \"BUY\",\n"
                + "  \"order_type\": \"MARKET\",\n"
                + "  \"order_tif\": \"DAY\",\n"
                + "  \"recipient_account_id\": \"recipient_account_id\",\n"
                + "  \"order_id\": \"order_id\",\n"
                + "  \"client_order_id\": \"client_order_id\",\n"
                + "  \"cancel_message\": \"cancel_message\",\n"
                + "  \"reject_message\": \"reject_message\"\n"
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
    public void testCreateLimitBuyManagedOrderRequestThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.managedOrders()
                        .createLimitBuyManagedOrderRequest(CreateLimitOrderBuyRequestInput.builder()
                                .accountId("account_id")
                                .assetQuantity(1.1)
                                .limitPrice(1.1)
                                .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"asset_quantity\": 1.1,\n" + "  \"limit_price\": 1.1\n" + "}";
        JsonNode actualJson = objectMapper.readTree(actualRequestBody);
        JsonNode expectedJson = objectMapper.readTree(expectedRequestBody);
        Assertions.assertTrue(jsonEquals(expectedJson, actualJson), "Request body structure does not match expected");
        if (actualJson.has("type") || actualJson.has("_type") || actualJson.has("kind")) {
            String discriminator = null;
            if (actualJson.has("type")) discriminator = actualJson.get("type").asText();
            else if (actualJson.has("_type"))
                discriminator = actualJson.get("_type").asText();
            else if (actualJson.has("kind"))
                discriminator = actualJson.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualJson.isNull()) {
            Assertions.assertTrue(
                    actualJson.isObject() || actualJson.isArray() || actualJson.isValueNode(),
                    "request should be a valid JSON value");
        }

        if (actualJson.isArray()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Array should have valid size");
        }
        if (actualJson.isObject()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Object should have valid field count");
        }

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
    public void testCreateLimitBuyManagedOrderRequestThrowsLockedError() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(423)
                .setBody("{\"status\":1,\"message\":\"message\",\"error_id\":\"error_id\"}"));
        LockedError exception = Assertions.assertThrows(LockedError.class, () -> client.managedOrders()
                .createLimitBuyManagedOrderRequest(CreateLimitOrderBuyRequestInput.builder()
                        .accountId("account_id")
                        .assetQuantity(1.1)
                        .limitPrice(1.1)
                        .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"asset_quantity\": 1.1,\n" + "  \"limit_price\": 1.1\n" + "}";
        JsonNode actualJson = objectMapper.readTree(actualRequestBody);
        JsonNode expectedJson = objectMapper.readTree(expectedRequestBody);
        Assertions.assertTrue(jsonEquals(expectedJson, actualJson), "Request body structure does not match expected");
        if (actualJson.has("type") || actualJson.has("_type") || actualJson.has("kind")) {
            String discriminator = null;
            if (actualJson.has("type")) discriminator = actualJson.get("type").asText();
            else if (actualJson.has("_type"))
                discriminator = actualJson.get("_type").asText();
            else if (actualJson.has("kind"))
                discriminator = actualJson.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualJson.isNull()) {
            Assertions.assertTrue(
                    actualJson.isObject() || actualJson.isArray() || actualJson.isValueNode(),
                    "request should be a valid JSON value");
        }

        if (actualJson.isArray()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Array should have valid size");
        }
        if (actualJson.isObject()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Object should have valid field count");
        }

        // Validate error response
        Assertions.assertEquals(423, exception.statusCode(), "Error status code does not match expected");
        String actualErrorJson = objectMapper.writeValueAsString(exception.body());
        String expectedErrorBody = ""
                + "{\n"
                + "  \"status\": 1,\n"
                + "  \"message\": \"message\",\n"
                + "  \"error_id\": \"error_id\"\n"
                + "}";
        JsonNode actualErrorNode = objectMapper.readTree(actualErrorJson);
        JsonNode expectedErrorNode = objectMapper.readTree(expectedErrorBody);
        Assertions.assertTrue(jsonEquals(expectedErrorNode, actualErrorNode), "Error body does not match expected");
    }

    @Test
    public void testCreateLimitSellManagedOrderRequest() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(201)
                        .setBody(
                                "{\"id\":\"id\",\"account_id\":\"account_id\",\"status\":\"QUOTED\",\"created_dt\":\"2024-01-15T09:30:00Z\",\"order_side\":\"BUY\",\"order_type\":\"MARKET\",\"order_tif\":\"DAY\",\"recipient_account_id\":\"recipient_account_id\",\"order_id\":\"order_id\",\"client_order_id\":\"client_order_id\",\"cancel_message\":\"cancel_message\",\"reject_message\":\"reject_message\"}"));
        OrderRequest response = client.managedOrders()
                .createLimitSellManagedOrderRequest(CreateLimitOrderSellRequestInput.builder()
                        .accountId("account_id")
                        .assetQuantity(1.1)
                        .limitPrice(1.1)
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"asset_quantity\": 1.1,\n" + "  \"limit_price\": 1.1\n" + "}";
        JsonNode actualJson = objectMapper.readTree(actualRequestBody);
        JsonNode expectedJson = objectMapper.readTree(expectedRequestBody);
        Assertions.assertTrue(jsonEquals(expectedJson, actualJson), "Request body structure does not match expected");
        if (actualJson.has("type") || actualJson.has("_type") || actualJson.has("kind")) {
            String discriminator = null;
            if (actualJson.has("type")) discriminator = actualJson.get("type").asText();
            else if (actualJson.has("_type"))
                discriminator = actualJson.get("_type").asText();
            else if (actualJson.has("kind"))
                discriminator = actualJson.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualJson.isNull()) {
            Assertions.assertTrue(
                    actualJson.isObject() || actualJson.isArray() || actualJson.isValueNode(),
                    "request should be a valid JSON value");
        }

        if (actualJson.isArray()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Array should have valid size");
        }
        if (actualJson.isObject()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Object should have valid field count");
        }

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"id\": \"id\",\n"
                + "  \"account_id\": \"account_id\",\n"
                + "  \"status\": \"QUOTED\",\n"
                + "  \"created_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"order_side\": \"BUY\",\n"
                + "  \"order_type\": \"MARKET\",\n"
                + "  \"order_tif\": \"DAY\",\n"
                + "  \"recipient_account_id\": \"recipient_account_id\",\n"
                + "  \"order_id\": \"order_id\",\n"
                + "  \"client_order_id\": \"client_order_id\",\n"
                + "  \"cancel_message\": \"cancel_message\",\n"
                + "  \"reject_message\": \"reject_message\"\n"
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
    public void testCreateLimitSellManagedOrderRequestThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.managedOrders()
                        .createLimitSellManagedOrderRequest(CreateLimitOrderSellRequestInput.builder()
                                .accountId("account_id")
                                .assetQuantity(1.1)
                                .limitPrice(1.1)
                                .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"asset_quantity\": 1.1,\n" + "  \"limit_price\": 1.1\n" + "}";
        JsonNode actualJson = objectMapper.readTree(actualRequestBody);
        JsonNode expectedJson = objectMapper.readTree(expectedRequestBody);
        Assertions.assertTrue(jsonEquals(expectedJson, actualJson), "Request body structure does not match expected");
        if (actualJson.has("type") || actualJson.has("_type") || actualJson.has("kind")) {
            String discriminator = null;
            if (actualJson.has("type")) discriminator = actualJson.get("type").asText();
            else if (actualJson.has("_type"))
                discriminator = actualJson.get("_type").asText();
            else if (actualJson.has("kind"))
                discriminator = actualJson.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualJson.isNull()) {
            Assertions.assertTrue(
                    actualJson.isObject() || actualJson.isArray() || actualJson.isValueNode(),
                    "request should be a valid JSON value");
        }

        if (actualJson.isArray()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Array should have valid size");
        }
        if (actualJson.isObject()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Object should have valid field count");
        }

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
    public void testCreateLimitSellManagedOrderRequestThrowsLockedError() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(423)
                .setBody("{\"status\":1,\"message\":\"message\",\"error_id\":\"error_id\"}"));
        LockedError exception = Assertions.assertThrows(LockedError.class, () -> client.managedOrders()
                .createLimitSellManagedOrderRequest(CreateLimitOrderSellRequestInput.builder()
                        .accountId("account_id")
                        .assetQuantity(1.1)
                        .limitPrice(1.1)
                        .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"asset_quantity\": 1.1,\n" + "  \"limit_price\": 1.1\n" + "}";
        JsonNode actualJson = objectMapper.readTree(actualRequestBody);
        JsonNode expectedJson = objectMapper.readTree(expectedRequestBody);
        Assertions.assertTrue(jsonEquals(expectedJson, actualJson), "Request body structure does not match expected");
        if (actualJson.has("type") || actualJson.has("_type") || actualJson.has("kind")) {
            String discriminator = null;
            if (actualJson.has("type")) discriminator = actualJson.get("type").asText();
            else if (actualJson.has("_type"))
                discriminator = actualJson.get("_type").asText();
            else if (actualJson.has("kind"))
                discriminator = actualJson.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualJson.isNull()) {
            Assertions.assertTrue(
                    actualJson.isObject() || actualJson.isArray() || actualJson.isValueNode(),
                    "request should be a valid JSON value");
        }

        if (actualJson.isArray()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Array should have valid size");
        }
        if (actualJson.isObject()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Object should have valid field count");
        }

        // Validate error response
        Assertions.assertEquals(423, exception.statusCode(), "Error status code does not match expected");
        String actualErrorJson = objectMapper.writeValueAsString(exception.body());
        String expectedErrorBody = ""
                + "{\n"
                + "  \"status\": 1,\n"
                + "  \"message\": \"message\",\n"
                + "  \"error_id\": \"error_id\"\n"
                + "}";
        JsonNode actualErrorNode = objectMapper.readTree(actualErrorJson);
        JsonNode expectedErrorNode = objectMapper.readTree(expectedErrorBody);
        Assertions.assertTrue(jsonEquals(expectedErrorNode, actualErrorNode), "Error body does not match expected");
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
