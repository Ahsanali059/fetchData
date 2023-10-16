import { Base_url } from "./CONFIG/conf.js";

class AjaxHelper 
   {
    constructor() 
    {
        this.BASE_URL = Base_url;
    }

    get(endPoint, successCallback, errorCallback) 
    {
        const req = new XMLHttpRequest();

        req.open('GET', this.BASE_URL + endPoint, true);

        req.onload = function() 
        {
            if (req.status === 200) 
            { 
                const data = JSON.parse(req.responseText);
                successCallback(data);
            } else {
                errorCallback(req.status, req.statusText);
            }
        };

        req.onerror = function() {
            errorCallback(req.status, req.statusText);
            
        };

        req.send();
    }
}

export { AjaxHelper }; 
