package com.acme.catchup.platform.news.domain.model.queries;

public record GetFavoriteSourceByIdQuery(Long id) {
    public GetFavoriteSourceByIdQuery {
        if (id == null || id.equals(0L))
            throw new IllegalArgumentException("ID must be a positive non-null value");
    }
}
