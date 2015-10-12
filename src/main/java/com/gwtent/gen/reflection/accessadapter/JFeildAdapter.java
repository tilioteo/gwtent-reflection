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


package com.gwtent.gen.reflection.accessadapter;

import com.google.gwt.core.ext.typeinfo.JField;
import com.gwtent.reflection.client.AccessDef;

public class JFeildAdapter implements AccessDef {

	private JField field;
	
	public JFeildAdapter(JField field){
		this.field = field;
	}

	public boolean isFinal() {
		return field.isFinal();
	}

	public boolean isPrivate() {
		return field.isPrivate();
	}

	public boolean isProtected() {
		return field.isProtected();
	}

	public boolean isPublic() {
		return field.isPublic();
	}

	public boolean isStatic() {
		return field.isStatic();
	}
	
}