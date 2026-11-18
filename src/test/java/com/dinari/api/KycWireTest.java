package com.dinari.api;

import com.dinari.api.core.ObjectMappers;
import com.dinari.api.errors.UnprocessableEntityError;
import com.dinari.api.resources.kyc.requests.CreateEntityKycRequest;
import com.dinari.api.resources.kyc.requests.CreateManagedKycInput;
import com.dinari.api.resources.kyc.requests.GetEntityKycDocumentRequest;
import com.dinari.api.resources.kyc.requests.GetEntityKycRequest;
import com.dinari.api.types.BaselineKycCheckDataV0;
import com.dinari.api.types.CreateBaselineKycInput;
import com.dinari.api.types.CreateKycInput;
import com.dinari.api.types.Kyc;
import com.dinari.api.types.KycDocument;
import com.dinari.api.types.ManagedKycEmbed;
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

public class KycWireTest {
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
    public void testGetEntityKyc() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"id\":\"id\",\"status\":\"PASS\",\"checked_dt\":\"2024-01-15T09:30:00Z\",\"data\":{\"country_code\":\"SG\",\"last_name\":\"Doe\",\"address_country_code\":\"SG\",\"first_name\":\"John\",\"middle_name\":\"middle_name\",\"email\":\"johndoe@website.com\",\"tax_id_number\":\"12-3456789\",\"birth_date\":\"1990-03-15\",\"address_street_1\":\"123 Main St.\",\"address_street_2\":\"Apt. 123\",\"address_city\":\"San Francisco\",\"address_subdivision\":\"California\",\"address_postal_code\":\"94111\"},\"jurisdiction\":\"BASELINE\"}"));
        Kyc response = client.kyc()
                .getEntityKyc(
                        GetEntityKycRequest.builder().entityId("entity_id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"id\": \"id\",\n"
                + "  \"status\": \"PASS\",\n"
                + "  \"checked_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"data\": {\n"
                + "    \"country_code\": \"SG\",\n"
                + "    \"last_name\": \"Doe\",\n"
                + "    \"address_country_code\": \"SG\",\n"
                + "    \"first_name\": \"John\",\n"
                + "    \"middle_name\": \"middle_name\",\n"
                + "    \"email\": \"johndoe@website.com\",\n"
                + "    \"tax_id_number\": \"12-3456789\",\n"
                + "    \"birth_date\": \"1990-03-15\",\n"
                + "    \"address_street_1\": \"123 Main St.\",\n"
                + "    \"address_street_2\": \"Apt. 123\",\n"
                + "    \"address_city\": \"San Francisco\",\n"
                + "    \"address_subdivision\": \"California\",\n"
                + "    \"address_postal_code\": \"94111\"\n"
                + "  },\n"
                + "  \"jurisdiction\": \"BASELINE\"\n"
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
    public void testCreateEntityKyc() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(201)
                        .setBody(
                                "{\"id\":\"id\",\"status\":\"PASS\",\"checked_dt\":\"2024-01-15T09:30:00Z\",\"data\":{\"country_code\":\"SG\",\"last_name\":\"Doe\",\"address_country_code\":\"SG\",\"first_name\":\"John\",\"middle_name\":\"middle_name\",\"email\":\"johndoe@website.com\",\"tax_id_number\":\"12-3456789\",\"birth_date\":\"1990-03-15\",\"address_street_1\":\"123 Main St.\",\"address_street_2\":\"Apt. 123\",\"address_city\":\"San Francisco\",\"address_subdivision\":\"California\",\"address_postal_code\":\"94111\"},\"jurisdiction\":\"BASELINE\"}"));
        Kyc response = client.kyc()
                .createEntityKyc(CreateEntityKycRequest.builder()
                        .entityId("entity_id")
                        .body(CreateKycInput.baseline(CreateBaselineKycInput.builder()
                                .data(BaselineKycCheckDataV0.builder()
                                        .countryCode("SG")
                                        .lastName("Doe")
                                        .addressCountryCode("SG")
                                        .build())
                                .providerName("provider_name")
                                .build()))
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"country_code\": \"SG\",\n"
                + "    \"last_name\": \"Doe\",\n"
                + "    \"address_country_code\": \"SG\"\n"
                + "  },\n"
                + "  \"provider_name\": \"provider_name\",\n"
                + "  \"jurisdiction\": \"BASELINE\"\n"
                + "}";
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
                + "  \"status\": \"PASS\",\n"
                + "  \"checked_dt\": \"2024-01-15T09:30:00Z\",\n"
                + "  \"data\": {\n"
                + "    \"country_code\": \"SG\",\n"
                + "    \"last_name\": \"Doe\",\n"
                + "    \"address_country_code\": \"SG\",\n"
                + "    \"first_name\": \"John\",\n"
                + "    \"middle_name\": \"middle_name\",\n"
                + "    \"email\": \"johndoe@website.com\",\n"
                + "    \"tax_id_number\": \"12-3456789\",\n"
                + "    \"birth_date\": \"1990-03-15\",\n"
                + "    \"address_street_1\": \"123 Main St.\",\n"
                + "    \"address_street_2\": \"Apt. 123\",\n"
                + "    \"address_city\": \"San Francisco\",\n"
                + "    \"address_subdivision\": \"California\",\n"
                + "    \"address_postal_code\": \"94111\"\n"
                + "  },\n"
                + "  \"jurisdiction\": \"BASELINE\"\n"
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
    public void testCreateEntityKycThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception = Assertions.assertThrows(UnprocessableEntityError.class, () -> client.kyc()
                .createEntityKyc(CreateEntityKycRequest.builder()
                        .entityId("entity_id")
                        .body(CreateKycInput.baseline(CreateBaselineKycInput.builder()
                                .data(BaselineKycCheckDataV0.builder()
                                        .countryCode("xy")
                                        .lastName("x")
                                        .addressCountryCode("xy")
                                        .build())
                                .providerName("x")
                                .build()))
                        .build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"jurisdiction\": \"BASELINE\",\n"
                + "  \"data\": {\n"
                + "    \"country_code\": \"xy\",\n"
                + "    \"last_name\": \"x\",\n"
                + "    \"address_country_code\": \"xy\"\n"
                + "  },\n"
                + "  \"provider_name\": \"x\"\n"
                + "}";
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
    public void testGetEntityKycDocument() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"id\":\"id\",\"document_type\":\"GOVERNMENT_ID\",\"filename\":\"filename\",\"url\":\"url\"}]"));
        List<KycDocument> response = client.kyc()
                .getEntityKycDocument(GetEntityKycDocumentRequest.builder()
                        .entityId("entity_id")
                        .kycId("kyc_id")
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
                + "    \"document_type\": \"GOVERNMENT_ID\",\n"
                + "    \"filename\": \"filename\",\n"
                + "    \"url\": \"url\"\n"
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
    public void testCreateManagedEntityKycEmbed() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"embed_url\":\"embed_url\",\"expiration_dt\":\"2024-01-15T09:30:00Z\"}"));
        ManagedKycEmbed response = client.kyc()
                .createManagedEntityKycEmbed(
                        CreateManagedKycInput.builder().entityId("entity_id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
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
                + "  \"embed_url\": \"embed_url\",\n"
                + "  \"expiration_dt\": \"2024-01-15T09:30:00Z\"\n"
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
    public void testCreateManagedEntityKycEmbedThrowsUnprocessableEntityError() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(422)
                        .setBody(
                                "{\"error_id\":\"error_id\",\"error\":{\"field_errors\":[{\"field_name\":\"field_name\",\"field_error\":\"field_error\"},{\"field_name\":\"field_name\",\"field_error\":\"field_error\"}]}}"));
        UnprocessableEntityError exception = Assertions.assertThrows(UnprocessableEntityError.class, () -> client.kyc()
                .createManagedEntityKycEmbed(
                        CreateManagedKycInput.builder().entityId("entity_id").build()));
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
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
