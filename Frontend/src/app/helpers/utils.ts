export default class Utils {
    static convertDate(val: Date) {
      console.log("Date String:", val.getFullYear(), val.getMonth(), val.getDate());

       return val.getFullYear()+'-'+(val.getMonth()+1)+'-'+val.getDate();
    }
}
