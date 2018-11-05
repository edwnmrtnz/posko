package com.github.posko.pos.injection.component;

import android.app.Application;

import com.github.posko.pos.PoskoApplication;
import com.github.posko.pos.RepositoryModuleProvider;
import com.github.posko.pos.ServiceConfigurationModule;
import com.github.posko.pos.injection.modules.ActivityBindings;
import com.github.posko.pos.injection.modules.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {

        AndroidSupportInjectionModule.class,

        App.class,

        ActivityBindings.class,

        ServiceConfigurationModule.class,

        RepositoryModuleProvider.class
})
public interface AppComponent extends AndroidInjector<PoskoApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
   // void inject();
}
