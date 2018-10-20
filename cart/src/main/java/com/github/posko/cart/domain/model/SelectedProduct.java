package com.github.posko.cart.domain.model;

import android.support.annotation.NonNull;

public class SelectedProduct {

    private Integer productId;

    private Integer variantId;

    private Integer unitId;

    private Double price;

    private Integer quantity;

    public Integer getProductId() {
        return productId;
    }

    public Integer getVariantId() {
        return variantId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTotal() {
        return price * quantity;
    }

    public SelectedProduct(Builder builder) {
        this.productId  = builder.productId;
        this.variantId  = builder.variantId;
        this.unitId     = builder.unitId;
        this.price      = builder.price;
        this.quantity   = builder.quantity;
    }

    public static class Builder {

        private Integer productId;

        private Integer variantId;

        private Integer unitId;

        private Double price;

        private Integer quantity;


        public Builder setProductId(@NonNull Integer productId) {
            this.productId = productId;
            return this;
        }

        public Builder setVariantId(@NonNull Integer variantId) {
            this.variantId = variantId;
            return this;
        }

        public Builder setUnitId(@NonNull Integer unitId) {
            this.unitId = unitId;
            return this;
        }

        public Builder setPrice(@NonNull Double price) {
            this.price = price;
            return this;
        }

        public Builder setQuantity(@NonNull Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public SelectedProduct build() {
            return new SelectedProduct(this);
        }
    }
}
