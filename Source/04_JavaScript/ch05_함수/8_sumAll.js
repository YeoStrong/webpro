/* 내장함수 중 Array 함수 : 
*  매개변수가 0개 : length가 0인 배열생성
*  매개변수가 1개일 때 : 매개변수만큼의 크기를 가지는 배열생성
*  매개변수가 2개이상일때는 매개변수로 배열을 만든다.  */ 
function sumAll(){ // arguments 배열에 실행시의 매개변수가 들어옴
    var result = 0;
    if(arguments.length == 0){
            result = -999;
    }else{
        for(var idx in arguments){
            result += arguments[idx];
        }
    }
    return result;
}