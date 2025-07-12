package com.acme.catchup.platform.news.domain.services;

import com.acme.catchup.platform.news.domain.model.aggregates.FavoriteSource;
import com.acme.catchup.platform.news.domain.model.queries.GetAllFavoriteSourcesByNewsApiKeyQuery;
import com.acme.catchup.platform.news.domain.model.queries.GetAllFavoriteSourcesBySourceIdQuery;
import com.acme.catchup.platform.news.domain.model.queries.GetFavoriteSourceByIdQuery;
import com.acme.catchup.platform.news.domain.model.queries.GetFavoriteSourceByNewsApiKeyAndSourceIdQuery;

import java.util.List;
import java.util.Optional;

public interface FavoriteSourceQueryService {
    List<FavoriteSource> handle(GetAllFavoriteSourcesByNewsApiKeyQuery query);
    List<FavoriteSource> handle(GetAllFavoriteSourcesBySourceIdQuery query);
    Optional<FavoriteSource> handle(GetFavoriteSourceByNewsApiKeyAndSourceIdQuery query);
    Optional<FavoriteSource> handle(GetFavoriteSourceByIdQuery query);
}
