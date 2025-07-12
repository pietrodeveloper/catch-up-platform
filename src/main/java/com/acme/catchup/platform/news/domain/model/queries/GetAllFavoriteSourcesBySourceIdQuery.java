package com.acme.catchup.platform.news.domain.model.queries;

public record GetAllFavoriteSourcesBySourceIdQuery(String sourceId) {
    public GetAllFavoriteSourcesBySourceIdQuery {
        if (sourceId == null || sourceId.isBlank())
            throw new IllegalArgumentException("Source ID cannot not be null or empty");
    }
}
