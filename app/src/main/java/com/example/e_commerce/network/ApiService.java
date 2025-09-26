package com.example.e_commerce.network;

import com.example.e_commerce.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("products") // replace with your actual endpoint
    Call<List<Product>> getProducts();
}
