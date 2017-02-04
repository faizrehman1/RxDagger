package com.moosa.rxdagger.dependencies;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Moosa on 03/02/2017.
 * moosa.bh@gmail.com
 */


@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomScope {
}
