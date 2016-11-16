package json;

import json.Components.Data;

/**
 * Created by lin on 2016/11/15.
 */
public class Json {
    int error;
    Data data;

    @Override
    public String toString() {
        return "Json{" +
                "error=" + error +
                ", data=" + data +
                '}';
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
