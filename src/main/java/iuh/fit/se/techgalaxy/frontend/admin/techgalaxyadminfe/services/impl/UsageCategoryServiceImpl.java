package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.UsageCategoryRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.UsageCategoryResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.Color;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.UsageCategoryService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class UsageCategoryServiceImpl implements UsageCategoryService {

    private RestClient restClient;
    private ObjectMapper objectMapper;
    private static final String ENDPOINT = "http://localhost:8081";

    public UsageCategoryServiceImpl(RestClient restClient, ObjectMapper objectMapper) {
        this.restClient = restClient;
        this.objectMapper = objectMapper;
    }
    @Override
    public DataResponse<UsageCategoryResponse> getAllUsageCategories() {
        return restClient.get()
                .uri(ENDPOINT + "/usageCategories")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    @Override
    public DataResponse<UsageCategoryResponse> getUsageCategoryById(String id) {
        return restClient.get()
                .uri(ENDPOINT + "/usageCategories/usageCategories/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
	@Override
	public DataResponse<UsageCategoryResponse> createUsageCategory(UsageCategoryRequest usageCategory,
			String accessToken) {
		 return restClient.post()
		            .uri(ENDPOINT + "/usageCategories")
		            .header("Authorization", "Bearer " + accessToken)
		            .body(usageCategory) 
		            .exchange((request, response) -> {
		                if (response.getBody().available() > 0) {
		                    DataResponse<UsageCategoryResponse> dataResponse = objectMapper.readValue(
		                        response.getBody().readAllBytes(),
		                        new TypeReference<>() {}
		                    );
		                    return dataResponse;
		                } else {
		                    return new DataResponse<>(); 
		                }
		            });
	}
	@Override
	public DataResponse<UsageCategoryResponse> updateUsageCategory(String id, UsageCategoryRequest usageCategory,
			String accessToken) {
		 return restClient.put()
		            .uri(ENDPOINT + "/usageCategories/usageCategories/"+id)
		            .header("Authorization", "Bearer " + accessToken)
		            .body(usageCategory) 
		            .exchange((request, response) -> {
		                if (response.getBody().available() > 0) {
		                    DataResponse<UsageCategoryResponse> dataResponse = objectMapper.readValue(
		                        response.getBody().readAllBytes(),
		                        new TypeReference<>() {}
		                    );
		                    return dataResponse;
		                } else {
		                    return new DataResponse<>(); 
		                }
		            });
	}
	@Override
	public DataResponse<UsageCategoryResponse> deleteUsageCategory(String id, String accessToken) {
		 return restClient.delete()
		            .uri(ENDPOINT + "/usageCategories/usageCategories/"+id)
		            .header("Authorization", "Bearer " + accessToken)
		            .exchange((request, response) -> {
		                if (response.getBody().available() > 0) {
		                    DataResponse<UsageCategoryResponse> dataResponse = objectMapper.readValue(
		                        response.getBody().readAllBytes(),
		                        new TypeReference<>() {}
		                    );
		                    return dataResponse;
		                } else {
		                    return new DataResponse<>(); 
		                }
		            });
	}

}
