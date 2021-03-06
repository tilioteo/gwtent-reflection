/*******************************************************************************
 *  Copyright 2001, 2007 JamesLuo(JamesLuo.au@gmail.com)
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *  
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 * 
 *  Contributors:
 *******************************************************************************/


package com.gwtent.reflection.client.impl;

import static com.google.gwt.core.ext.typeinfo.JniConstants.DESC_BOOLEAN;
import static com.google.gwt.core.ext.typeinfo.JniConstants.DESC_BYTE;
import static com.google.gwt.core.ext.typeinfo.JniConstants.DESC_CHAR;
import static com.google.gwt.core.ext.typeinfo.JniConstants.DESC_DOUBLE;
import static com.google.gwt.core.ext.typeinfo.JniConstants.DESC_FLOAT;
import static com.google.gwt.core.ext.typeinfo.JniConstants.DESC_INT;
import static com.google.gwt.core.ext.typeinfo.JniConstants.DESC_LONG;
import static com.google.gwt.core.ext.typeinfo.JniConstants.DESC_SHORT;
import static com.google.gwt.core.ext.typeinfo.JniConstants.DESC_VOID;

import java.util.HashMap;
import java.util.Map;

import com.gwtent.reflection.client.ArrayType;
import com.gwtent.reflection.client.ClassType;
import com.gwtent.reflection.client.EnumType;
import com.gwtent.reflection.client.ParameterizedType;
import com.gwtent.reflection.client.PrimitiveType;
import com.gwtent.reflection.client.Type;


public class PrimitiveTypeImpl extends TypeImpl implements Type, PrimitiveType {


  private static Map<String, PrimitiveType> map;

  public static PrimitiveType valueOf(String typeName) {
    return getMap().get(typeName);
  }

  public static PrimitiveTypeImpl create(String name, String boxedName, char jni) {
  	PrimitiveTypeImpl type = new PrimitiveTypeImpl(name, boxedName,
        String.valueOf(jni));
    Object existing = getMap().put(name, type);
    assert (existing == null);
    return type;
  }

  private static Map<String, PrimitiveType> getMap() {
    if (map == null) {
      map = new HashMap<String, PrimitiveType>();
    }
    return map;
  }

  private final String boxedName;

  private final String jni;

  private final String name;

  private PrimitiveTypeImpl(String name, String boxedName, String jni) {
    this.name = name;
    this.boxedName = boxedName;
    this.jni = jni;
  }


  @Override
  public String getJNISignature() {
    return jni;
  }

  public String getQualifiedBoxedSourceName() {
    return "java.lang." + boxedName;
  }


  @Override
  public ArrayType isArray() {
    // intentional null
    return null;
  }

  @Override
  public ClassType isClass() {
    // intentional null
    return null;
  }

  @Override
  public EnumType isEnum() {
    return null;
  }


  @Override
  public ClassType isInterface() {
    // intentional null
    return null;
  }

  @Override
  public ParameterizedType isParameterized() {
    // intentional null
    return null;
  }

  @Override
  public PrimitiveType isPrimitive() {
    return this;
  }

  @Override
  public String toString() {
    return name;
  }

	public String getQualifiedSourceName() {
		return name;
	}

	public String getSimpleSourceName() {
		return name;
	}

}
