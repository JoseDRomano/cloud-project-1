package main;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.core.Application;
import resources.BlobsResources;
import utils.Props;

public class MainApplication extends Application
{
	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> resources = new HashSet<>();

	public MainApplication() {
		resources.add(BlobsResources.class);
		//singletons.add(new BlobsResources());
		
		Props.load("azurekeys-region.props"); //place the props file in resources folder under java/main
	}

	@Override
	public Set<Class<?>> getClasses() {
		return resources;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}