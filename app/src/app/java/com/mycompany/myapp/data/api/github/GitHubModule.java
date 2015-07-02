package com.mycompany.myapp.data.api.github;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.myapp.data.api.Api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.converter.Converter;
import retrofit.converter.JacksonConverter;

@Module
public class GitHubModule {
    @Singleton
    @Api("github")
    @Provides
    Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint("https://api.github.com");
    }

    @Singleton
    @Api("github")
    @Provides
    Converter provideConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return new JacksonConverter(objectMapper);
    }

    @Singleton
    @Api("github")
    @Provides
    RestAdapter provideRestAdapter(Client client, @Api("github") Endpoint endpoint, @Api("github") Converter converter) {
        return new RestAdapter.Builder()
                .setClient(client)
                .setConverter(converter)
                .setEndpoint(endpoint)
                .build();
    }

    @Singleton
    @Provides
    GitHubService provideGitHubService(@Api("github") RestAdapter restAdapter) {
        return restAdapter.create(GitHubService.class);
    }
}
