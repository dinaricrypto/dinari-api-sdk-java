package com.dinari.api;

import com.dinari.api.core.ObjectMappers;
import com.dinari.api.errors.BadRequestError;
import com.dinari.api.errors.ConflictError;
import com.dinari.api.errors.NotFoundError;
import com.dinari.api.errors.UnprocessableEntityError;
import com.dinari.api.resources.orders.requests.BatchCancelOrderInput;
import com.dinari.api.resources.orders.requests.CreateOrderCancellationRequest;
import com.dinari.api.resources.orders.requests.GetAccountAllOrderFulfillmentsRequest;
import com.dinari.api.resources.orders.requests.GetAccountOrderFulfillmentByIdRequest;
import com.dinari.api.resources.orders.requests.GetAccountOrderFulfillmentsRequest;
import com.dinari.api.resources.orders.requests.GetEntityOrdersRequest;
import com.dinari.api.resources.orders.requests.GetOrderByIdRequest;
import com.dinari.api.resources.orders.requests.GetOrdersRequest;
import com.dinari.api.resources.orders.types.GetAccountAllOrderFulfillmentsResponse;
import com.dinari.api.resources.orders.types.GetAccountOrderFulfillmentsResponse;
import com.dinari.api.resources.orders.types.GetEntityOrdersResponse;
import com.dinari.api.resources.orders.types.GetOrdersResponse;
import com.dinari.api.types.BatchCancelOrderResponse;
import com.dinari.api.types.Order;
import com.dinari.api.types.OrderFulfillment;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrdersWireTest {
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
    public void testGetEntityOrders() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"id\":\"id\",\"status\":\"PENDING_SUBMIT\",\"chain_id\":\"chain_id\",\"order_contract_address\":\"order_contract_address\",\"order_transaction_hash\":\"order_transaction_hash\",\"order_side\":\"BUY\",\"order_type\":\"MARKET\",\"order_tif\":\"DAY\",\"payment_token\":\"payment_token\",\"stock_id\":\"stock_id\",\"created_dt\":\"2024-01-15T09:30:00Z\",\"asset_token\":\"asset_token\",\"asset_token_quantity\":\"asset_token_quantity\",\"payment_token_quantity\":\"payment_token_quantity\",\"limit_price\":\"limit_price\",\"fee\":\"fee\",\"cancel_transaction_hash\":\"cancel_transaction_hash\",\"entity_id\":\"entity_id\",\"account_id\":\"account_id\",\"order_request_id\":\"order_request_id\",\"client_order_id\":\"client_order_id\"}]"));
        GetEntityOrdersResponse response =
                client.orders().getEntityOrders(GetEntityOrdersRequest.builder().build());
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
                + "    \"status\": \"PENDING_SUBMIT\",\n"
                + "    \"chain_id\": \"chain_id\",\n"
                + "    \"order_contract_address\": \"order_contract_address\",\n"
                + "    \"order_transaction_hash\": \"order_transaction_hash\",\n"
                + "    \"order_side\": \"BUY\",\n"
                + "    \"order_type\": \"MARKET\",\n"
                + "    \"order_tif\": \"DAY\",\n"
                + "    \"payment_token\": \"payment_token\",\n"
                + "    \"stock_id\": \"stock_id\",\n"
                + "    \"created_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "    \"asset_token\": \"asset_token\",\n"
                + "    \"asset_token_quantity\": \"asset_token_quantity\",\n"
                + "    \"payment_token_quantity\": \"payment_token_quantity\",\n"
                + "    \"limit_price\": \"limit_price\",\n"
                + "    \"fee\": \"fee\",\n"
                + "    \"cancel_transaction_hash\": \"cancel_transaction_hash\",\n"
                + "    \"entity_id\": \"entity_id\",\n"
                + "    \"account_id\": \"account_id\",\n"
                + "    \"order_request_id\": \"order_request_id\",\n"
                + "    \"client_order_id\": \"client_order_id\"\n"
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
    public void testGetEntityOrdersThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.orders()
                        .getEntityOrders(GetEntityOrdersRequest.builder().build()));
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
    public void testGetOrders() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"id\":\"id\",\"status\":\"PENDING_SUBMIT\",\"chain_id\":\"chain_id\",\"order_contract_address\":\"order_contract_address\",\"order_transaction_hash\":\"order_transaction_hash\",\"order_side\":\"BUY\",\"order_type\":\"MARKET\",\"order_tif\":\"DAY\",\"payment_token\":\"payment_token\",\"stock_id\":\"stock_id\",\"created_dt\":\"2024-01-15T09:30:00Z\",\"asset_token\":\"asset_token\",\"asset_token_quantity\":\"asset_token_quantity\",\"payment_token_quantity\":\"payment_token_quantity\",\"limit_price\":\"limit_price\",\"fee\":\"fee\",\"cancel_transaction_hash\":\"cancel_transaction_hash\",\"order_request_id\":\"order_request_id\",\"client_order_id\":\"client_order_id\"}]"));
        GetOrdersResponse response = client.orders()
                .getOrders(GetOrdersRequest.builder().accountId("account_id").build());
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
                + "    \"status\": \"PENDING_SUBMIT\",\n"
                + "    \"chain_id\": \"chain_id\",\n"
                + "    \"order_contract_address\": \"order_contract_address\",\n"
                + "    \"order_transaction_hash\": \"order_transaction_hash\",\n"
                + "    \"order_side\": \"BUY\",\n"
                + "    \"order_type\": \"MARKET\",\n"
                + "    \"order_tif\": \"DAY\",\n"
                + "    \"payment_token\": \"payment_token\",\n"
                + "    \"stock_id\": \"stock_id\",\n"
                + "    \"created_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "    \"asset_token\": \"asset_token\",\n"
                + "    \"asset_token_quantity\": \"asset_token_quantity\",\n"
                + "    \"payment_token_quantity\": \"payment_token_quantity\",\n"
                + "    \"limit_price\": \"limit_price\",\n"
                + "    \"fee\": \"fee\",\n"
                + "    \"cancel_transaction_hash\": \"cancel_transaction_hash\",\n"
                + "    \"order_request_id\": \"order_request_id\",\n"
                + "    \"client_order_id\": \"client_order_id\"\n"
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
    public void testGetOrdersThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.orders()
                        .getOrders(GetOrdersRequest.builder()
                                .accountId("account_id")
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
    public void testGetOrderById() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"id\":\"id\",\"status\":\"PENDING_SUBMIT\",\"chain_id\":\"eip155:1\",\"order_contract_address\":\"order_contract_address\",\"order_transaction_hash\":\"order_transaction_hash\",\"order_side\":\"BUY\",\"order_type\":\"MARKET\",\"order_tif\":\"DAY\",\"payment_token\":\"payment_token\",\"created_dt\":\"2024-01-15T09:30:00Z\",\"stock_id\":\"stock_id\",\"alloy_id\":\"alloy_id\",\"asset_token\":\"asset_token\",\"asset_token_quantity\":\"asset_token_quantity\",\"payment_token_quantity\":\"payment_token_quantity\",\"limit_price\":\"limit_price\",\"fee\":\"fee\",\"cancel_transaction_hash\":\"cancel_transaction_hash\",\"order_request_id\":\"order_request_id\",\"client_order_id\":\"client_order_id\"}"));
        Order response = client.orders()
                .getOrderById(GetOrderByIdRequest.builder()
                        .accountId("account_id")
                        .orderId("order_id")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"id\": \"id\",\n"
                + "  \"status\": \"PENDING_SUBMIT\",\n"
                + "  \"chain_id\": \"eip155:1\",\n"
                + "  \"order_contract_address\": \"order_contract_address\",\n"
                + "  \"order_transaction_hash\": \"order_transaction_hash\",\n"
                + "  \"order_side\": \"BUY\",\n"
                + "  \"order_type\": \"MARKET\",\n"
                + "  \"order_tif\": \"DAY\",\n"
                + "  \"payment_token\": \"payment_token\",\n"
                + "  \"created_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"stock_id\": \"stock_id\",\n"
                + "  \"alloy_id\": \"alloy_id\",\n"
                + "  \"asset_token\": \"asset_token\",\n"
                + "  \"asset_token_quantity\": \"asset_token_quantity\",\n"
                + "  \"payment_token_quantity\": \"payment_token_quantity\",\n"
                + "  \"limit_price\": \"limit_price\",\n"
                + "  \"fee\": \"fee\",\n"
                + "  \"cancel_transaction_hash\": \"cancel_transaction_hash\",\n"
                + "  \"order_request_id\": \"order_request_id\",\n"
                + "  \"client_order_id\": \"client_order_id\"\n"
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
    public void testCreateOrderCancellation() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"id\":\"id\",\"status\":\"PENDING_SUBMIT\",\"chain_id\":\"eip155:1\",\"order_contract_address\":\"order_contract_address\",\"order_transaction_hash\":\"order_transaction_hash\",\"order_side\":\"BUY\",\"order_type\":\"MARKET\",\"order_tif\":\"DAY\",\"payment_token\":\"payment_token\",\"created_dt\":\"2024-01-15T09:30:00Z\",\"stock_id\":\"stock_id\",\"alloy_id\":\"alloy_id\",\"asset_token\":\"asset_token\",\"asset_token_quantity\":\"asset_token_quantity\",\"payment_token_quantity\":\"payment_token_quantity\",\"limit_price\":\"limit_price\",\"fee\":\"fee\",\"cancel_transaction_hash\":\"cancel_transaction_hash\",\"order_request_id\":\"order_request_id\",\"client_order_id\":\"client_order_id\"}"));
        Order response = client.orders()
                .createOrderCancellation(CreateOrderCancellationRequest.builder()
                        .accountId("account_id")
                        .orderId("order_id")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"id\": \"id\",\n"
                + "  \"status\": \"PENDING_SUBMIT\",\n"
                + "  \"chain_id\": \"eip155:1\",\n"
                + "  \"order_contract_address\": \"order_contract_address\",\n"
                + "  \"order_transaction_hash\": \"order_transaction_hash\",\n"
                + "  \"order_side\": \"BUY\",\n"
                + "  \"order_type\": \"MARKET\",\n"
                + "  \"order_tif\": \"DAY\",\n"
                + "  \"payment_token\": \"payment_token\",\n"
                + "  \"created_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"stock_id\": \"stock_id\",\n"
                + "  \"alloy_id\": \"alloy_id\",\n"
                + "  \"asset_token\": \"asset_token\",\n"
                + "  \"asset_token_quantity\": \"asset_token_quantity\",\n"
                + "  \"payment_token_quantity\": \"payment_token_quantity\",\n"
                + "  \"limit_price\": \"limit_price\",\n"
                + "  \"fee\": \"fee\",\n"
                + "  \"cancel_transaction_hash\": \"cancel_transaction_hash\",\n"
                + "  \"order_request_id\": \"order_request_id\",\n"
                + "  \"client_order_id\": \"client_order_id\"\n"
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
    public void testCreateOrderCancellationThrowsBadRequestError() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(400)
                .setBody("{\"status\":1,\"message\":\"message\",\"error_id\":\"error_id\"}"));
        BadRequestError exception = Assertions.assertThrows(BadRequestError.class, () -> client.orders()
                .createOrderCancellation(CreateOrderCancellationRequest.builder()
                        .accountId("account_id")
                        .orderId("order_id")
                        .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());

        // Validate error response
        Assertions.assertEquals(400, exception.statusCode(), "Error status code does not match expected");
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
    public void testCreateOrderCancellationThrowsNotFoundError() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(404)
                .setBody("{\"status\":1,\"message\":\"message\",\"error_id\":\"error_id\"}"));
        NotFoundError exception = Assertions.assertThrows(NotFoundError.class, () -> client.orders()
                .createOrderCancellation(CreateOrderCancellationRequest.builder()
                        .accountId("account_id")
                        .orderId("order_id")
                        .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());

        // Validate error response
        Assertions.assertEquals(404, exception.statusCode(), "Error status code does not match expected");
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
    public void testCreateOrderCancellationThrowsConflictError() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(409)
                .setBody("{\"status\":1,\"message\":\"message\",\"error_id\":\"error_id\"}"));
        ConflictError exception = Assertions.assertThrows(ConflictError.class, () -> client.orders()
                .createOrderCancellation(CreateOrderCancellationRequest.builder()
                        .accountId("account_id")
                        .orderId("order_id")
                        .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());

        // Validate error response
        Assertions.assertEquals(409, exception.statusCode(), "Error status code does not match expected");
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
    public void testCreateBatchOrderCancellation() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"cancel_queued_orders\":[{\"id\":\"id\",\"status\":\"PENDING_SUBMIT\",\"chain_id\":\"eip155:1\",\"order_contract_address\":\"order_contract_address\",\"order_transaction_hash\":\"order_transaction_hash\",\"order_side\":\"BUY\",\"order_type\":\"MARKET\",\"order_tif\":\"DAY\",\"payment_token\":\"payment_token\",\"created_dt\":\"2024-01-15T09:30:00Z\",\"stock_id\":\"stock_id\",\"alloy_id\":\"alloy_id\",\"asset_token\":\"asset_token\",\"asset_token_quantity\":\"asset_token_quantity\",\"payment_token_quantity\":\"payment_token_quantity\",\"limit_price\":\"limit_price\",\"fee\":\"fee\",\"cancel_transaction_hash\":\"cancel_transaction_hash\",\"order_request_id\":\"order_request_id\",\"client_order_id\":\"client_order_id\"}],\"failed_to_cancel_orders\":[{\"id\":\"id\",\"status\":\"PENDING_SUBMIT\",\"chain_id\":\"eip155:1\",\"order_contract_address\":\"order_contract_address\",\"order_transaction_hash\":\"order_transaction_hash\",\"order_side\":\"BUY\",\"order_type\":\"MARKET\",\"order_tif\":\"DAY\",\"payment_token\":\"payment_token\",\"created_dt\":\"2024-01-15T09:30:00Z\",\"stock_id\":\"stock_id\",\"alloy_id\":\"alloy_id\",\"asset_token\":\"asset_token\",\"asset_token_quantity\":\"asset_token_quantity\",\"payment_token_quantity\":\"payment_token_quantity\",\"limit_price\":\"limit_price\",\"fee\":\"fee\",\"cancel_transaction_hash\":\"cancel_transaction_hash\",\"order_request_id\":\"order_request_id\",\"client_order_id\":\"client_order_id\"}]}"));
        BatchCancelOrderResponse response = client.orders()
                .createBatchOrderCancellation(BatchCancelOrderInput.builder()
                        .accountId("account_id")
                        .orderIds(Arrays.asList("order_ids"))
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"order_ids\": [\n" + "    \"order_ids\"\n" + "  ]\n" + "}";
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
                + "  \"cancel_queued_orders\": [\n"
                + "    {\n"
                + "      \"id\": \"id\",\n"
                + "      \"status\": \"PENDING_SUBMIT\",\n"
                + "      \"chain_id\": \"eip155:1\",\n"
                + "      \"order_contract_address\": \"order_contract_address\",\n"
                + "      \"order_transaction_hash\": \"order_transaction_hash\",\n"
                + "      \"order_side\": \"BUY\",\n"
                + "      \"order_type\": \"MARKET\",\n"
                + "      \"order_tif\": \"DAY\",\n"
                + "      \"payment_token\": \"payment_token\",\n"
                + "      \"created_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "      \"stock_id\": \"stock_id\",\n"
                + "      \"alloy_id\": \"alloy_id\",\n"
                + "      \"asset_token\": \"asset_token\",\n"
                + "      \"asset_token_quantity\": \"asset_token_quantity\",\n"
                + "      \"payment_token_quantity\": \"payment_token_quantity\",\n"
                + "      \"limit_price\": \"limit_price\",\n"
                + "      \"fee\": \"fee\",\n"
                + "      \"cancel_transaction_hash\": \"cancel_transaction_hash\",\n"
                + "      \"order_request_id\": \"order_request_id\",\n"
                + "      \"client_order_id\": \"client_order_id\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"failed_to_cancel_orders\": [\n"
                + "    {\n"
                + "      \"id\": \"id\",\n"
                + "      \"status\": \"PENDING_SUBMIT\",\n"
                + "      \"chain_id\": \"eip155:1\",\n"
                + "      \"order_contract_address\": \"order_contract_address\",\n"
                + "      \"order_transaction_hash\": \"order_transaction_hash\",\n"
                + "      \"order_side\": \"BUY\",\n"
                + "      \"order_type\": \"MARKET\",\n"
                + "      \"order_tif\": \"DAY\",\n"
                + "      \"payment_token\": \"payment_token\",\n"
                + "      \"created_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "      \"stock_id\": \"stock_id\",\n"
                + "      \"alloy_id\": \"alloy_id\",\n"
                + "      \"asset_token\": \"asset_token\",\n"
                + "      \"asset_token_quantity\": \"asset_token_quantity\",\n"
                + "      \"payment_token_quantity\": \"payment_token_quantity\",\n"
                + "      \"limit_price\": \"limit_price\",\n"
                + "      \"fee\": \"fee\",\n"
                + "      \"cancel_transaction_hash\": \"cancel_transaction_hash\",\n"
                + "      \"order_request_id\": \"order_request_id\",\n"
                + "      \"client_order_id\": \"client_order_id\"\n"
                + "    }\n"
                + "  ]\n"
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
    public void testCreateBatchOrderCancellationThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.orders()
                        .createBatchOrderCancellation(BatchCancelOrderInput.builder()
                                .accountId("account_id")
                                .orderIds(Arrays.asList("order_ids", "order_ids"))
                                .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody =
                "" + "{\n" + "  \"order_ids\": [\n" + "    \"order_ids\",\n" + "    \"order_ids\"\n" + "  ]\n" + "}";
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
    public void testGetAccountAllOrderFulfillments() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"id\":\"id\",\"order_id\":\"order_id\",\"chain_id\":\"chain_id\",\"transaction_hash\":\"transaction_hash\",\"transaction_dt\":\"2024-01-15T09:30:00Z\",\"asset_token_filled\":\"asset_token_filled\",\"payment_token_spent\":\"payment_token_spent\",\"asset_token_spent\":\"asset_token_spent\",\"payment_token_filled\":\"payment_token_filled\",\"stock_id\":\"stock_id\",\"alloy_id\":\"alloy_id\",\"payment_token_fee\":\"payment_token_fee\"}]"));
        GetAccountAllOrderFulfillmentsResponse response = client.orders()
                .getAccountAllOrderFulfillments(GetAccountAllOrderFulfillmentsRequest.builder()
                        .accountId("account_id")
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
                + "    \"id\": \"id\",\n"
                + "    \"order_id\": \"order_id\",\n"
                + "    \"chain_id\": \"chain_id\",\n"
                + "    \"transaction_hash\": \"transaction_hash\",\n"
                + "    \"transaction_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "    \"asset_token_filled\": \"asset_token_filled\",\n"
                + "    \"payment_token_spent\": \"payment_token_spent\",\n"
                + "    \"asset_token_spent\": \"asset_token_spent\",\n"
                + "    \"payment_token_filled\": \"payment_token_filled\",\n"
                + "    \"stock_id\": \"stock_id\",\n"
                + "    \"alloy_id\": \"alloy_id\",\n"
                + "    \"payment_token_fee\": \"payment_token_fee\"\n"
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
    public void testGetAccountAllOrderFulfillmentsThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.orders()
                        .getAccountAllOrderFulfillments(GetAccountAllOrderFulfillmentsRequest.builder()
                                .accountId("account_id")
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
    public void testGetAccountOrderFulfillments() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"id\":\"id\",\"order_id\":\"order_id\",\"chain_id\":\"chain_id\",\"transaction_hash\":\"transaction_hash\",\"transaction_dt\":\"2024-01-15T09:30:00Z\",\"asset_token_filled\":\"asset_token_filled\",\"payment_token_spent\":\"payment_token_spent\",\"asset_token_spent\":\"asset_token_spent\",\"payment_token_filled\":\"payment_token_filled\",\"stock_id\":\"stock_id\",\"alloy_id\":\"alloy_id\",\"payment_token_fee\":\"payment_token_fee\"}]"));
        GetAccountOrderFulfillmentsResponse response = client.orders()
                .getAccountOrderFulfillments(GetAccountOrderFulfillmentsRequest.builder()
                        .accountId("account_id")
                        .orderId("order_id")
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
                + "    \"id\": \"id\",\n"
                + "    \"order_id\": \"order_id\",\n"
                + "    \"chain_id\": \"chain_id\",\n"
                + "    \"transaction_hash\": \"transaction_hash\",\n"
                + "    \"transaction_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "    \"asset_token_filled\": \"asset_token_filled\",\n"
                + "    \"payment_token_spent\": \"payment_token_spent\",\n"
                + "    \"asset_token_spent\": \"asset_token_spent\",\n"
                + "    \"payment_token_filled\": \"payment_token_filled\",\n"
                + "    \"stock_id\": \"stock_id\",\n"
                + "    \"alloy_id\": \"alloy_id\",\n"
                + "    \"payment_token_fee\": \"payment_token_fee\"\n"
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
    public void testGetAccountOrderFulfillmentsThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.orders()
                        .getAccountOrderFulfillments(GetAccountOrderFulfillmentsRequest.builder()
                                .accountId("account_id")
                                .orderId("order_id")
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
    public void testGetAccountOrderFulfillmentById() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"id\":\"id\",\"order_id\":\"order_id\",\"chain_id\":\"eip155:1\",\"transaction_hash\":\"transaction_hash\",\"transaction_dt\":\"2024-01-15T09:30:00Z\",\"asset_token_filled\":\"asset_token_filled\",\"payment_token_spent\":\"payment_token_spent\",\"asset_token_spent\":\"asset_token_spent\",\"payment_token_filled\":\"payment_token_filled\",\"stock_id\":\"stock_id\",\"alloy_id\":\"alloy_id\",\"payment_token_fee\":\"payment_token_fee\"}"));
        OrderFulfillment response = client.orders()
                .getAccountOrderFulfillmentById(GetAccountOrderFulfillmentByIdRequest.builder()
                        .accountId("account_id")
                        .orderFulfillmentId("order_fulfillment_id")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"id\": \"id\",\n"
                + "  \"order_id\": \"order_id\",\n"
                + "  \"chain_id\": \"eip155:1\",\n"
                + "  \"transaction_hash\": \"transaction_hash\",\n"
                + "  \"transaction_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"asset_token_filled\": \"asset_token_filled\",\n"
                + "  \"payment_token_spent\": \"payment_token_spent\",\n"
                + "  \"asset_token_spent\": \"asset_token_spent\",\n"
                + "  \"payment_token_filled\": \"payment_token_filled\",\n"
                + "  \"stock_id\": \"stock_id\",\n"
                + "  \"alloy_id\": \"alloy_id\",\n"
                + "  \"payment_token_fee\": \"payment_token_fee\"\n"
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
