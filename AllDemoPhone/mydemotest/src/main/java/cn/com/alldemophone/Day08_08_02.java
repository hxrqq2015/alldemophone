/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\javaeeTool\\AndroidStudio\\MyApplication\\AllDemoPhone\\app\\src\\main\\aidl\\cn\\com\\alldemophone\\Day08_08_02.aidl
 */
package cn.com.alldemophone;
// Declare any non-default types here with import statements

public interface Day08_08_02 extends android.os.IInterface {
    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements cn.com.alldemophone.Day08_08_02 {
        private static final java.lang.String DESCRIPTOR = "cn.com.alldemophone.Day08_08_02";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an cn.com.alldemophone.Day08_08_02 interface,
         * generating a proxy if needed.
         */
        public static cn.com.alldemophone.Day08_08_02 asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof cn.com.alldemophone.Day08_08_02))) {
                return ((cn.com.alldemophone.Day08_08_02) iin);
            }
            return new cn.com.alldemophone.Day08_08_02.Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_callSafePay: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    int _arg2;
                    _arg2 = data.readInt();
                    int _result = this.callSafePay(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements cn.com.alldemophone.Day08_08_02 {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override
            public int callSafePay(java.lang.String username, java.lang.String pwd, int money) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(username);
                    _data.writeString(pwd);
                    _data.writeInt(money);
                    mRemote.transact(Stub.TRANSACTION_callSafePay, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
        }

        static final int TRANSACTION_callSafePay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    }

    public int callSafePay(java.lang.String username, java.lang.String pwd, int money) throws android.os.RemoteException;
}
