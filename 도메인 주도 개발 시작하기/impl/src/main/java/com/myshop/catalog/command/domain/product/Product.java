package com.myshop.catalog.command.domain.product;

import com.myshop.catalog.command.domain.category.CategoryId;
import com.myshop.common.jpa.MoneyConverter;
import com.myshop.common.model.Money;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @EmbeddedId
    private ProductId id;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"))
    private Set<CategoryId> categoryIds;

    private String name;

    @Convert(converter = MoneyConverter.class)
    private Money price;

    private String detail;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @OrderColumn(name = "list_idx")
    private final List<Image> images = new ArrayList<>();

    protected Product() {
    }

    public Product(ProductId id, String name, Money price, String detail, List<Image> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.images.addAll(images);
    }

    public ProductId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public String getDetail() {
        return detail;
    }

    public List<Image> getImages() {
        return Collections.unmodifiableList(images);
    }

    public void changeImages(List<Image> newImages) {
        images.clear();
        images.addAll(newImages);
    }

    public String getFirstIamgeThumbnailPath() {
        if (images.isEmpty()) return null;
        return images.get(0).getThumbnailUrl();
    }
}
