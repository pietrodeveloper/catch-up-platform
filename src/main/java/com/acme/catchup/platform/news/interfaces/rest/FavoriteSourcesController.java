package com.acme.catchup.platform.news.interfaces.rest;

import com.acme.catchup.platform.news.domain.model.aggregates.FavoriteSource;
import com.acme.catchup.platform.news.domain.model.commands.CreateFavoriteSourceCommand;
import com.acme.catchup.platform.news.domain.services.FavoriteSourceCommandService;
import com.acme.catchup.platform.news.infrastructure.persistence.jpa.FavoriteSourceRepository;
import com.acme.catchup.platform.news.interfaces.rest.resources.CreateFavoriteSourceResource;
import com.acme.catchup.platform.news.interfaces.rest.resources.FavoriteSourceResource;
import com.acme.catchup.platform.news.interfaces.rest.transform.CreateFavoriteSourceCommandFromResourceAssembler;
import com.acme.catchup.platform.news.interfaces.rest.transform.FavoriteSourceResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/favorite-sources")
public class FavoriteSourcesController {
    private final FavoriteSourceCommandService favoriteSourceCommandService;
    private final FavoriteSourceRepository favoriteSourceRepository;

    public FavoriteSourcesController(FavoriteSourceCommandService favoriteSourceCommandService, FavoriteSourceRepository favoriteSourceRepository) {
        this.favoriteSourceCommandService = favoriteSourceCommandService;
        this.favoriteSourceRepository = favoriteSourceRepository;
    }

    @PostMapping
    public ResponseEntity<FavoriteSourceResource> createFavoriteSource(@RequestBody CreateFavoriteSourceResource resource) {
        Optional<FavoriteSource> favoriteSource = favoriteSourceCommandService.handle(CreateFavoriteSourceCommandFromResourceAssembler.toCommandFromResources(resource));
        return favoriteSource.map(source -> new ResponseEntity<>(FavoriteSourceResourceFromEntityAssembler.toResourceFromEntity(source), HttpStatus.CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
