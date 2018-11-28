package com.rohan.actorinfo.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.widget.LinearLayout;


import com.rohan.actorinfo.home.model.HeroModel;
import com.rohan.actorinfo.home.repo.HomeRepo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;


@RunWith(JUnit4.class)
public class HomeViewModelTest {


    @Mock
    private HomeRepo repo;
    private HomeViewModel viewModel;

    private LiveData<List<HeroModel>> liveData = new MutableLiveData<>();



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
       viewModel = new HomeViewModel();
    }

    @Test
    public void init() {
    }

    @Test
    public void getHeroes() {

        Mockito.when(repo.getHeroData()).thenReturn(liveData);
    }
}