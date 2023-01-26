// var str = '안녕00방가00좋은아침00좋은하루'; // 00 -> x 교체
// console.log('원본 str : ' + str);
// var splitStr = str.split('00'); // ['안녕', '방가', '좋은아침', '좋은하루']
// console.log('분할된 str : ' + splitStr);
// var joinStr = splitStr.join('x');
// console.log('join된 str : ' + joinStr);

function replaceAll(str, oldStr, newStr){
    // let splitStr = str.split(oldStr);
    // let result = splitStr.join(newStr);
    // return result;
    return str.split(oldStr).join(newStr);
}
// var replaceStr = replaceAll('Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', ' ', '');
// console.log('결과 : ' + replaceStr);