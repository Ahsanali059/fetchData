import { Base_url } from "./CONFIG/conf.js"

class AjaxHelper {
    constructor() {
        this.BASE_URL = Base_url;
    }

    get(url, successCallback, errorCallback) 
    {
        $.ajax({
            url: this.BASE_URL + url,
            method: GET,
            success: successCallback,
            error: errorCallback,
        });
    }

    post(url, successCallback, errorCallback) 
    {
        $.ajax({
            url: this.BASE_URL + url,
            method: POST,
            data: data,
            success: successCallback,
            error: errorCallback,
        })
    }

}

export {
    AjaxHelper
}

