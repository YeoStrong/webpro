const person = {
    'name':'홍길동',
    'age':20,
};
person.name = '신길동'; // const는 상수지만 객체 상수일 때는 내부값 변경 가능

const arr = ['홍길동', 20];
// const arr = {0:'홍길동', 1:20};
console.log('arr[0] = ', arr[0] + ' / arr[1] = ' + arr[1]);
console.log('person["name"]=', person['name'], "/ person['age']=", person['age']);
console.log('person.name=', person.name, "/ person.age=", person.age);