package com.example.team_project.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.team_project.R;
import com.example.team_project.adapter.CategoryAdapter;
import com.example.team_project.adapter.PopularProductsAdapter;
import com.example.team_project.adapter.ProductAdapter;
import com.example.team_project.databinding.FragmentHomePageBinding;
import com.example.team_project.models.Category;
import com.example.team_project.models.PopularProducts;
import com.example.team_project.models.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class HomePageFragment extends Fragment {


    private FragmentHomePageBinding binding;

    RecyclerView catRecyclerview,newProductRecycleview,popularRecycleview;

    //Product recycleview
    ProductAdapter productAdapter;
    List<Product> productList;


    //Category recycleview
    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    //Popular Products
    PopularProductsAdapter popularProductsAdapter;
    List<PopularProducts> popularProductsList;


    //Fire store
    FirebaseFirestore db;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        //init
        binding = FragmentHomePageBinding.inflate(inflater, container, false);
        ImageSlider imageSlider = binding.getRoot().findViewById(R.id.image_slider);
        catRecyclerview = binding.getRoot().findViewById(R.id.rec_category);
        db = FirebaseFirestore.getInstance();
        newProductRecycleview = binding.getRoot().findViewById(R.id.new_product_rec);
        popularRecycleview = binding.getRoot().findViewById(R.id.popular_rec);

        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.banner1,"Discount On Shoes Items", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.banner2,"Discount On Perfume", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.banner3,"70%", ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(slideModels);

        //category
        catRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        categoryList = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(getActivity(),categoryList);
        catRecyclerview.setAdapter(categoryAdapter);

        //db
        db.collection("Category")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Category category = document.toObject(Category.class);
                                categoryList.add(category);
                                categoryAdapter.notifyDataSetChanged();
                            }
                        } else {

                        }
                    }
                });

        //New Products
        newProductRecycleview.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(getActivity(),productList);
        newProductRecycleview.setAdapter(productAdapter);

        db.collection("Products")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Product product = document.toObject(Product.class);
                                productList.add(product);
                                productAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        //Popular Products
        popularRecycleview.setLayoutManager(new GridLayoutManager(getActivity(),2));
        popularProductsList = new ArrayList<>();
        popularProductsAdapter = new PopularProductsAdapter(getActivity(),popularProductsList);
        popularRecycleview.setAdapter(popularProductsAdapter);

        db.collection("AllProducts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                PopularProducts popular_product = document.toObject(PopularProducts.class);
                                popularProductsList.add(popular_product);
                                popularProductsAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        return binding.getRoot();


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
//        List<SlideModel> slideModels = new ArrayList<>();
//
//        slideModels.add(new SlideModel(R.drawable.banner1,"Discount On Shoes Items", ScaleTypes.CENTER_CROP));
//        slideModels.add(new SlideModel(R.drawable.banner2,"Discount On Perfume", ScaleTypes.CENTER_CROP));
//        slideModels.add(new SlideModel(R.drawable.banner3,"70%", ScaleTypes.CENTER_CROP));
//        imageSlider.setImageList(slideModels);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}