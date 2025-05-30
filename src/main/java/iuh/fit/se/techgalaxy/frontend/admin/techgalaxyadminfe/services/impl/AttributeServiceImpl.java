package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.AttributeRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.AttributeValueRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.AttributeValueUpdateRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.AttributeResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.ValueResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.AttributeService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {


    private final RestClient restClient;
    private final ObjectMapper objectMapper;
    private static final String ENDPOINT = "http://localhost:8081";

    public AttributeServiceImpl(RestClient restClient, ObjectMapper objectMapper, ObjectMapper objectMapper1) {
        this.restClient = restClient;
        this.objectMapper = objectMapper1;
    }

    @Override
    public DataResponse<ValueResponse> getAttributesByVariantId(String variantId) {
        return restClient.get()
                .uri(ENDPOINT + "/attributes/attributeByVariantId/" + variantId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public DataResponse<AttributeResponse> getAllAttribute() {
        return restClient.get()
                .uri(ENDPOINT + "/attributes")
                .exchange((request, response) -> {
                            System.out.println("getAllAttribute");
                            System.out.println(response.getStatusCode());
                            DataResponse<AttributeResponse> attributeResponseDataResponse = null;
                            if (response.getBody().available() > 0) {
                                attributeResponseDataResponse = objectMapper.readValue(response.getBody().readAllBytes(), new TypeReference<>() {
                                });
                            }
                            assert attributeResponseDataResponse != null;
                            return attributeResponseDataResponse;
                        }
                );
    }

    @Override
    public DataResponse<AttributeResponse> getAttributeById(String id) {
        return restClient.get()
                .uri(ENDPOINT + "/attributes/attributes/" + id)
                .exchange((request, response) -> {
                            System.out.println("getAttributeById");
                            System.out.println(response.getStatusCode());
                            DataResponse<AttributeResponse> attributeResponseDataResponse = null;
                            if (response.getBody().available() > 0) {
                                attributeResponseDataResponse = objectMapper.readValue(response.getBody().readAllBytes(), new TypeReference<>() {
                                });
                            }
                            assert attributeResponseDataResponse != null;
                            return attributeResponseDataResponse;
                        }
                );
    }


    @Override
    public DataResponse<Object> createAttributeValueByVariantId(String variantId, List<AttributeValueRequest> values, String accessToken) {
        values.forEach(System.out::println);
        return restClient.post()
                .uri(ENDPOINT + "/attributes/productvariant/" + variantId)
                .header("Authorization", "Bearer " + accessToken)
                .body(values)
                .exchange((request, response) -> {
                    System.out.println("createAttributeValueByVariantId");
                    System.out.println(response.getStatusCode());
                    DataResponse<Object> attributeResponseDataResponse = null;
                    if (response.getBody().available() > 0) {
                        attributeResponseDataResponse = objectMapper.readValue(response.getBody().readAllBytes(), new TypeReference<>() {
                        });
                    }
                    assert attributeResponseDataResponse != null;
                    return attributeResponseDataResponse;
                });
    }

    @Override
    public DataResponse<ValueResponse> getValueByNameAtribute(String name) {
        return restClient.get()
                .uri(ENDPOINT + "/attributes/atributevalue/" + name)
                .exchange((request, response) -> {

                            System.out.println("getValueByNameAtribute");
                            DataResponse<ValueResponse> attributeResponseDataResponse = null;
                            if (response.getBody().available() > 0) {
                                attributeResponseDataResponse = objectMapper.readValue(response.getBody().readAllBytes(), new TypeReference<>() {
                                });
                            }
                            assert attributeResponseDataResponse != null;
                            return attributeResponseDataResponse;
                        }
                );
    }

    @Override
    public DataResponse<ValueResponse> updateValueProductVariant(String variantId, AttributeValueUpdateRequest attributeValueRequest, String accessToken) {
        return restClient.put()
                .uri(ENDPOINT + "/attributes/productvariant/" + variantId)
                .header("Authorization", "Bearer " + accessToken)
                .body(attributeValueRequest)
                .exchange((request, response) -> {
                            System.out.println("updateValueProductVariant");
                            System.out.println(response.getStatusCode());
                            DataResponse<ValueResponse> attributeResponseDataResponse = null;
                            if (response.getBody().available() > 0) {
                                attributeResponseDataResponse = objectMapper.readValue(response.getBody().readAllBytes(), new TypeReference<>() {
                                });
                            }
                            assert attributeResponseDataResponse != null;
                            return attributeResponseDataResponse;
                        }
                );
    }

    @Override
    public DataResponse<ValueResponse> deleteValue(String valueId, String accessToken) {
        return restClient.delete()
                .uri(ENDPOINT + "/attributes/value/" + valueId)
                .header("Authorization", "Bearer " + accessToken)
                .exchange((request, response) -> {
                            System.out.println("deleteValue");
                            System.out.println(response.getStatusCode());
                            DataResponse<ValueResponse> attributeResponseDataResponse = null;
                            if (response.getBody().available() > 0) {
                                attributeResponseDataResponse = objectMapper.readValue(response.getBody().readAllBytes(), new TypeReference<>() {
                                });
                            }
                            assert attributeResponseDataResponse != null;
                            return attributeResponseDataResponse;
                        }
                );
    }

    @Override
    public DataResponse<ValueResponse> getValueById(String valueId) {
        return restClient.get()
                .uri(ENDPOINT + "/attributes/value/" + valueId)
                .exchange((request, response) -> {
                            System.out.println("getValueById");
                            System.out.println(response.getStatusCode());
                            DataResponse<ValueResponse> attributeResponseDataResponse = null;
                            if (response.getBody().available() > 0) {
                                attributeResponseDataResponse = objectMapper.readValue(response.getBody().readAllBytes(), new TypeReference<>() {
                                });
                            }
                            assert attributeResponseDataResponse != null;
                            return attributeResponseDataResponse;
                        }
                );
    }

    @Override
    public DataResponse<AttributeResponse> createAttribute(AttributeRequest request, String accessToken) {
        return  restClient.post()
                .uri(ENDPOINT + "/attributes")
                .header("Authorization", "Bearer " + accessToken)
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .exchange((req, resp) -> {
                    System.out.println("createAttribute");
                    System.out.println(resp.getStatusCode());
                    DataResponse<AttributeResponse> result = null;
                    if (resp.getBody().available() > 0) {
                        result = objectMapper.readValue(
                            resp.getBody().readAllBytes(),
                            new TypeReference<DataResponse<AttributeResponse>>() {}
                        );
                    }
                    assert result != null;
                    return result;
                });
    }

    @Override
    public DataResponse<ValueResponse> deleteAttribute(String attributeId, String accessToken) {
        return restClient.delete()
                .uri(ENDPOINT + "/attributes/attributes/" + attributeId)
                .header("Authorization", "Bearer " + accessToken)
                .exchange((req, resp) -> {
                    System.out.println("deleteAttribute");
                    System.out.println(resp.getStatusCode());
                    DataResponse<ValueResponse> result = null;
                    if (resp.getBody().available() > 0) {
                        result = objectMapper.readValue(
                            resp.getBody().readAllBytes(),
                            new TypeReference<DataResponse<ValueResponse>>() {}
                        );
                    }
                    assert result != null;
                    return result;
                });
    }


}
