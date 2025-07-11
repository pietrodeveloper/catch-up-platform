package com.acme.catchup.platform.news.domain.model.queries;

public record GetFavoriteSourceByNewsApiKeyAndSourceIdQuery(String newsApiKey, String sourceId) {
    public GetFavoriteSourceByNewsApiKeyAndSourceIdQuery {
        if (newsApiKey == null || newsApiKey.isBlank())
            throw new IllegalArgumentException("NewsAPIKey cannot be null or blank");
        if (sourceId == null || sourceId.isBlank())
            throw new IllegalArgumentException("SourceId cannot be null or blank");
    }
}
