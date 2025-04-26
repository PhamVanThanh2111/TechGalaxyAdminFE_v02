package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.ColorRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.ValueResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.Color;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.ColorService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ColorServiceImpl implements ColorService{

    private RestClient restClient;
    private ObjectMapper objectMapper;
    private static final String ENDPOINT = "http://localhost:8081";
    public ColorServiceImpl(RestClient restClient, ObjectMapper objectMapper) {
        this.restClient = restClient;
        this.objectMapper = objectMapper;
    }
    @Override
    public DataResponse<Color> getAllColors() {
        return restClient.get()
                .uri(ENDPOINT + "/colors")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public DataResponse<Color> getColorById(String id) {
        return restClient.get()
                .uri(ENDPOINT + "/colors/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
	@Override
	public DataResponse<Color> createColor(ColorRequest name, String accessToken) {
		  return restClient.post()
		            .uri(ENDPOINT + "/colors")
		            .header("Authorization", "Bearer " + accessToken)
		            .body(name) 
		            .exchange((request, response) -> {
		                System.out.println("createColor");
		                System.out.println("Status code: " + response.getStatusCode());

		                if (response.getBody().available() > 0) {
		                    DataResponse<Color> dataResponse = objectMapper.readValue(
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
	public DataResponse<Color> deleteColor(String colorId ,String accessToken) {
		return restClient.delete()
	            .uri(ENDPOINT + "/colors/" + colorId)
	            .header("Authorization", "Bearer " + accessToken)
	            .exchange((req, resp) -> {
	                System.out.println("deleteColor");
	                System.out.println("Status: " + resp.getStatusCode());

	                DataResponse<Color> result = null;
	                if (resp.getBody().available() > 0) {
	                    result = objectMapper.readValue(
	                        resp.getBody().readAllBytes(),
	                        new TypeReference<DataResponse<Color>>() {}
	                    );
	                }
	                if (result == null) {
	                    throw new RuntimeException("Không có dữ liệu trả về khi xoá color!");
	                }
	                return result;
	            });
	}
	@Override
	public DataResponse<Color> updateColor(String colorId, ColorRequest color,String accessToken) {
		
		 return restClient.put()
		            .uri(ENDPOINT + "/colors/"+colorId)
		            .header("Authorization", "Bearer " + accessToken)
		            .body(color) 
		            .exchange((request, response) -> {
		                System.out.println("createColor");
		                System.out.println("Status code: " + response.getStatusCode());

		                if (response.getBody().available() > 0) {
		                    DataResponse<Color> dataResponse = objectMapper.readValue(
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
