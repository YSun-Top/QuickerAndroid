package cuiliang.quicker.client;


/**
 * PC 连接状态
 */
public enum ConnectionStatus {
    Disconnected, //未连接
    Connecting, //连接中
    Connected, //已连接
    CONNECT_FAIL,//连接失败
    CLOSE, //连接关闭
    LoggedIn, // 已登录
    LoginFailed, // 登录失败
}
