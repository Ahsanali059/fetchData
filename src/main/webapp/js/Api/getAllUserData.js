import { AjaxHelper } from "../AjaxHelper"

class getUser{
    constructor()
    {
        //instance
        this.AjaxHelper = new AjaxHelper();
    }

    getUser(successCallback,errorCallback)
    {
      const apiEndPoint = "/getUser";

      this.AjaxHelper.get(apiEndPoint,successCallback,errorCallback);


    }
}
export
{
    getUser
}
