package com.acme.catchup.platform.news.domain.services;

import com.acme.catchup.platform.news.domain.model.aggregates.FavoriteSource;
import com.acme.catchup.platform.news.domain.model.queries.GetAllFavoriteSourcesByNewsApiKeyQuery;

import java.util.List;

public interface FavoriteSourceQueryService {
    List<FavoriteSource> handle(GetAllFavoriteSourcesByNewsApiKeyQuery query);
}
