//    {
//        // 验证token
//        "path": '/logCheck',
//        "method": 'get',
//        data: {
//            status: 10000,
//            infor: 'success',
//
//            status: 10001,
//            infor: 'error',
//
//            status: 10002,
//            infor: '没有token',
//        }
//    },
//
//
//            {
//            ​    // 注册
//            ​    path: '/log_up',
//            ​    method: 'post',
//            ​    data: {
//            ​      status: 10000,
//            ​      infor: 'success',
//
//            ​      status: 10001,
//            ​      infor: 'error',
//
//            ​      // 发送数据{name:string,account:number,password:string}
//            ​    }
//            },
//
//
//            {
//            ​    // 登录
//            ​    path: '/log_in',
//            ​    method: 'post',
//            ​    data: {
//            ​      status: 10000,
//            ​      infor: 'success',
//
//            ​      status: 10001,
//            ​      infor: 'error',
//
//            ​      // 发送数据{account:number,password:string}
//            ​    }
//            },
//
//
//            {
//            ​    // 个人
//            ​    path: '/myinfor',
//            ​    method: 'get',
//            ​    data: {
//            ​      status: 10000,
//            ​      infor: 'success',
//            ​      data: {
//            ​        name: string,
//            ​        count: number
//            ​      },
//
//            ​      status: 10001,
//            ​      infor: 'error',
//
//            ​    }
//            },
//
//
//            {
//            ​    // 上传
//            ​    path: '/upload',
//            ​    method: 'post',
//            ​    data: {
//            ​      status: 10000,
//            ​      infor: 'success',
//
//            ​      status: 10001,
//            ​      infor: 'error',
//
//            ​    }
//            },
//
//
//            {
//            ​    // 排行榜
//            ​    path: '/toplist',
//            ​    method: 'get',
//            ​    data: {
//            ​      status: 10000,
//            ​      infor: 'success',
//            ​      data:[
//            ​        {name:string,account:number},
//            ​        {name:string,account:number},
//            ​        {name:string,account:number},
//            ​      ]
//
//            ​      status: 10001,
//            ​      infor: 'error',
//
//            ​    }
//            }