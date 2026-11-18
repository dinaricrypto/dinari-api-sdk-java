package com.dinari.api;

import com.dinari.api.core.ObjectMappers;
import com.dinari.api.errors.UnprocessableEntityError;
import com.dinari.api.resources.entities.requests.CreateEntityInput;
import com.dinari.api.resources.entities.requests.GetEntitiesRequest;
import com.dinari.api.resources.entities.requests.GetEntityByIdRequest;
import com.dinari.api.resources.entities.requests.PatchEntityInput;
import com.dinari.api.resources.entities.types.GetEntitiesResponse;
import com.dinari.api.types.Entity1;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntitiesWireTest {
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
    public void testGetEntities() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"id\":\"id\",\"is_kyc_complete\":true,\"entity_type\":\"INDIVIDUAL\",\"name\":\"name\",\"nationality\":\"nationality\",\"reference_id\":\"reference_id\"}]"));
        GetEntitiesResponse response =
                client.entities().getEntities(GetEntitiesRequest.builder().build());
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
                + "    \"is_kyc_complete\": true,\n"
                + "    \"entity_type\": \"INDIVIDUAL\",\n"
                + "    \"name\": \"name\",\n"
                + "    \"nationality\": \"nationality\",\n"
                + "    \"reference_id\": \"reference_id\"\n"
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
    public void testGetEntitiesThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.entities()
                        .getEntities(GetEntitiesRequest.builder().build()));
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
    public void testCreateEntities() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"id\":\"id\",\"is_kyc_complete\":true,\"entity_type\":\"INDIVIDUAL\",\"name\":\"name\",\"nationality\":\"nationality\",\"reference_id\":\"reference_id\"}"));
        Entity1 response = client.entities()
                .createEntities(CreateEntityInput.builder().name("name").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"name\": \"name\"\n" + "}";
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
                + "  \"is_kyc_complete\": true,\n"
                + "  \"entity_type\": \"INDIVIDUAL\",\n"
                + "  \"name\": \"name\",\n"
                + "  \"nationality\": \"nationality\",\n"
                + "  \"reference_id\": \"reference_id\"\n"
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
    public void testCreateEntitiesThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.entities()
                        .createEntities(CreateEntityInput.builder().name("x").build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"name\": \"x\"\n" + "}";
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
    public void testGetCurrentEntity() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"id\":\"id\",\"is_kyc_complete\":true,\"entity_type\":\"INDIVIDUAL\",\"name\":\"name\",\"nationality\":\"nationality\",\"reference_id\":\"reference_id\"}"));
        Entity1 response = client.entities().getCurrentEntity();
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"id\": \"id\",\n"
                + "  \"is_kyc_complete\": true,\n"
                + "  \"entity_type\": \"INDIVIDUAL\",\n"
                + "  \"name\": \"name\",\n"
                + "  \"nationality\": \"nationality\",\n"
                + "  \"reference_id\": \"reference_id\"\n"
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
    public void testGetEntityById() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"id\":\"id\",\"is_kyc_complete\":true,\"entity_type\":\"INDIVIDUAL\",\"name\":\"name\",\"nationality\":\"nationality\",\"reference_id\":\"reference_id\"}"));
        Entity1 response = client.entities()
                .getEntityById(
                        GetEntityByIdRequest.builder().entityId("entity_id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"id\": \"id\",\n"
                + "  \"is_kyc_complete\": true,\n"
                + "  \"entity_type\": \"INDIVIDUAL\",\n"
                + "  \"name\": \"name\",\n"
                + "  \"nationality\": \"nationality\",\n"
                + "  \"reference_id\": \"reference_id\"\n"
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
    public void testUpdateEntityById() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"id\":\"id\",\"is_kyc_complete\":true,\"entity_type\":\"INDIVIDUAL\",\"name\":\"name\",\"nationality\":\"nationality\",\"reference_id\":\"reference_id\"}"));
        Entity1 response = client.entities()
                .updateEntityById(
                        PatchEntityInput.builder().entityId("entity_id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{}";
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
                + "  \"is_kyc_complete\": true,\n"
                + "  \"entity_type\": \"INDIVIDUAL\",\n"
                + "  \"name\": \"name\",\n"
                + "  \"nationality\": \"nationality\",\n"
                + "  \"reference_id\": \"reference_id\"\n"
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
    public void testUpdateEntityByIdThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception =
                Assertions.assertThrows(UnprocessableEntityError.class, () -> client.entities()
                        .updateEntityById(
                                PatchEntityInput.builder().entityId("entity_id").build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{}";
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
