package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.MemoryRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.Memory;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.MemoryService;

import java.io.InputStream;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MemoryServiceImpl implements MemoryService {

    private RestClient restClient;
    private ObjectMapper objectMapper;
    private static final String ENDPOINT = "http://localhost:8081";

    public MemoryServiceImpl(RestClient restClient, ObjectMapper objectMapper) {
        this.restClient = restClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public DataResponse<Memory> getAllMemories() {
        return restClient.get()
                .uri(ENDPOINT + "/memories")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public  DataResponse<Memory> getMemoryById(String id) {
        return restClient.get()
                .uri(ENDPOINT + "/memories/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    
	@Override
	public DataResponse<Memory> createMemory(MemoryRequest memoryRequest, String accessToken) {
	    return restClient.post()
	        .uri(ENDPOINT + "/memories")
	        .header("Authorization", "Bearer " + accessToken)
	        .body(memoryRequest)
	        .exchange((request, response) -> {
	            InputStream responseBody = response.getBody();
	            if (responseBody != null && responseBody.available() > 0) {
	                return objectMapper.readValue(
	                    responseBody,
	                    new TypeReference<DataResponse<Memory>>() {}
	                );
	            } else {
	                return new DataResponse<>(); 
	            }
	        });
	}

	@Override
	public DataResponse<Memory> updateMemory(String id, MemoryRequest memoryRequest, String accessToken) {
		
		 return restClient.put()
		            .uri(ENDPOINT + "/memories/"+id)
		            .header("Authorization", "Bearer " + accessToken)
		            .body(memoryRequest) 
		            .exchange((request, response) -> {

		                if (response.getBody().available() > 0) {
		                    DataResponse<Memory> dataResponse = objectMapper.readValue(
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
	public DataResponse<Memory> deleteMemory(String memoryId, String accessToken) {
		return restClient.delete()
	            .uri(ENDPOINT + "/memories/" + memoryId)
	            .header("Authorization", "Bearer " + accessToken)
	            .exchange((req, resp) -> {
	                DataResponse<Memory> result = null;
	                if (resp.getBody().available() > 0) {
	                    result = objectMapper.readValue(
	                        resp.getBody().readAllBytes(),
	                        new TypeReference<DataResponse<Memory>>() {}
	                    );
	                }
	                if (result == null) {
	                    throw new RuntimeException("Không có dữ liệu trả về khi xoá memory!");
	                }
	                return result;
	            });
	}

 
}
