package com.ct.demo.commercetools.product;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.ProductPagedQueryResponse;
import io.vrap.rmf.base.client.ApiHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {
    @Autowired
    private ProjectApiRoot projectApiRoot;

    public CompletableFuture<ProductPagedQueryResponse> getAllProducts() {
        return projectApiRoot.products().get().execute().thenApply(ApiHttpResponse::getBody);
    }
}
