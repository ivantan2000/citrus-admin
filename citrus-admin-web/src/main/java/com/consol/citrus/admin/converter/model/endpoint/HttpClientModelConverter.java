package com.consol.citrus.admin.converter.model.endpoint;

import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.http.client.HttpEndpointConfiguration;
import com.consol.citrus.model.config.http.HttpClientModel;
import org.springframework.stereotype.Component;

/**
 * @author Christoph Deppisch
 */
@Component
public class HttpClientModelConverter extends AbstractEndpointModelConverter<HttpClientModel, HttpClient, HttpEndpointConfiguration> {

    /**
     * Default constructor.
     */
    public HttpClientModelConverter() {
        super(HttpClientModel.class, HttpClient.class, HttpEndpointConfiguration.class);
    }

    @Override
    public HttpClientModel convert(String id, HttpClient model) {
        HttpClientModel converted = convert(model);
        converted.setId(id);
        return converted;
    }

    @Override
    public String getJavaConfig(HttpClientModel model) {
        return getJavaConfig(model, model.getId(), "http().client()");
    }
}