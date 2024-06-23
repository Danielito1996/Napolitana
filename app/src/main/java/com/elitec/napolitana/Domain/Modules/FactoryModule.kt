package com.elitec.napolitana.Domain.Modules

import com.elitec.napolitana.Domain.GenericFactory
import com.elitec.napolitana.Domain.IGenericsFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FactoryModule {
	@Binds //Permite especificar que clase concreta implementara una interfaz
	@Singleton
	abstract fun bindIGenericFactory(factory: GenericFactory): IGenericsFactory
}