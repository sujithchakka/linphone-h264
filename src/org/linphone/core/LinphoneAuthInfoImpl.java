/*
LinphoneAuthInfoImpl.java
Copyright (C) 2010  Belledonne Communications, Grenoble, France

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/
package org.linphone.core;

class LinphoneAuthInfoImpl implements LinphoneAuthInfo {
	protected final long nativePtr;
	private native long newLinphoneAuthInfo(String username, String userid, String passwd, String ha1,String realm);
	private native void  delete(long ptr);
	protected LinphoneAuthInfoImpl(String username,String password)  {
		nativePtr = newLinphoneAuthInfo(username,null,password,null,null);
	}
	protected void finalize() throws Throwable {
		delete(nativePtr);
	}
}