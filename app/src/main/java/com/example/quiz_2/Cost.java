package com.example.quiz_2;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Cost implements Parcelable{
    public String type;
    public int tarifType;
    public String tambahan;
    public int tarifTambahan;
    public int waktu;

    public Cost() {
    }

    protected Cost(Parcel in) {
        type = in.readString();
        tarifType = in.readInt();
        tambahan = in.readString();
        tarifTambahan = in.readInt();
        waktu = in.readInt();
    }

    public static final Creator<Cost> CREATOR = new Creator<Cost>() {
        @Override
        public Cost createFromParcel(Parcel in) {
            return new Cost(in);
        }

        @Override
        public Cost[] newArray(int size) {
            return new Cost[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTarifType() {
        return tarifType;
    }

    public void setTarifType(int tarifType) {
        this.tarifType = tarifType;
    }

    public String getTambahan() {
        return tambahan;
    }

    public void setTambahan(String tambahan) {
        this.tambahan = tambahan;
    }

    public int getTarifTambahan() {
        return tarifTambahan;
    }

    public void setTarifTambahan(int tarifTambahan) {
        this.tarifTambahan = tarifTambahan;
    }

    public int getWaktu() {
        return waktu;
    }

    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeInt(tarifType);
        dest.writeString(tambahan);
        dest.writeInt(tarifTambahan);
        dest.writeInt(waktu);
    }
}
