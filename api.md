```json
    // 验证token
    path: '/log_check',
    method: 'get',

{
    "status": 10000,
    "infor": "success",

    "status": 10001,
    "infor": "error",//有token，但此token未匹配到用户

    "status": 10002,
    "infor": "没有token",
}

```



```json
    // 注册
    path: '/log_up',
    method: 'post',

{
    "status": 10000,
    "infor": "success",

    "status": 10001,
    "infor": "error",//有未知异常，数据库过载、服务器出现问题等
    
    "status": 20001,
    "infor": "用户已存在"

    // 发送数据{name:string, schoolNum:number, password:string}
}

```

```json
    // 登录
    path: '/log_in',
    method: 'post',

{
    "status": 10000,
    "infor": "success",//登陆成功，首次登陆

    "status": 10001,
    "infor": "用户不存在"，
    
    "status": 20000,
    "infor": "匹配成功", //登陆成功。已登录过，并和浏览器的token匹配成功
    

    // 发送数据{schoolNum:number, password:string}
}

```

```json
    // 个人数据
    path: '/myinfor',
    method: 'get',

{
    "status": 10000,
    "infor": 'success',
    "data": {
        "name": string,
        "rice": number
    },

    "status": 10001,
    "infor": "error"
}

```

```json
    // 上传
    path: '/upload',
    method: 'post',

{
    "status": 10000,
    "infor": "success",

    "status": 10001,
    "infor": "文件为空",
    
    "status": 10002,
    "infor": "上传次数已达到今天的限制"
    
    "status": 10003,
    "infor": "存储图片失败"
    
    "status": 10004,
    "infor": "路径写入数据库失败"
    
    "status": 10005,
    "infor": "非上传时段"
}

```

```json
    // 排行榜
    path: '/toplist',
    method: 'get',

{
    "status": 10000,
    "infor": "success",
    "data": [
        {
            "name": string,
            "rice": number
        },
        {
            "name": string,
            "rice": number
        }
    ],

    "status": 10001,
    "infor": "error",
}

```

```json
    // 后台数据
    path: '/pics_address',
    method: 'get',

{
    "status": 10000,
    "infor": "success",
    "data": [
        {
            "name": string,
            "schoolNum": string,
            "time": number,
            "address": string
        },
        {
            "name": "yhf",
            "schoolNum": "2019212",
            "time": 1,  //1代表中午，2代表晚上
            "address": "morning/test.jpg"
        }
    ],

    "status": 10001,
    "infor": "error",
}
```

```json
	//是否通过
    path: '/pass',
    method: 'post',
{
    "schoolNum": string,
    "time": number, 
    "result": number
}

//示例：
{
    "schoolNum": "2019212",
    "time": 1,  //1代表中午，2代表晚上
    "result": 1 //0代表不通过，1代表通过
}

```
