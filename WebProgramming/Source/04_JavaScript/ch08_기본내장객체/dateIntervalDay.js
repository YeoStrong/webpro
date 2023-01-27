// today.getIntervalDay(openday) : today부터 openday까지의 기간의 날짜를 return
// this는 today, that은 openday
Date.prototype.getIntervalDay = function(that){ // this~that까지의 기간 날 return
    var intervalMilliSec = Math.abs(this.getTime()-that.getTime());
    var day = intervalMilliSec / (1000 * 60 * 60 * 24);
    return Math.trunc(day);
};