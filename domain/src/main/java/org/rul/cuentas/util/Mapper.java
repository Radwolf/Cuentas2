package org.rul.cuentas.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rgonzalez on 02/12/2016.
 */

public abstract class Mapper<K, T> {

    public abstract K map(T type);

    public abstract T reverseMap(K type);

    public List<K> mapList(List<T> typeList){

        List<K> list = new ArrayList<>();

        for( T type : typeList ){

            list.add( map( type ) );

        }

        return list;

    }

    public List<T> reverseMapList(List<K> typeList){

        List<T> list = new ArrayList<>();

        for( K type : typeList ){

            list.add( reverseMap( type ) );

        }

        return list;

    }

}