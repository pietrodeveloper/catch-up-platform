package com.acme.catchup.platform.news.domain.model.queries;

public record GetAllFavoriteSourcesByNewsApiKeyQuery(String newsApiKey) {
    public GetAllFavoriteSourcesByNewsApiKeyQuery {
        if (newsApiKey == null || newsApiKey.isBlank())
            throw new IllegalArgumentException("News API key cannot not be null or empty");
    }
}
