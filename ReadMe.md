扩展：权限拦截Filter的URL的一些说明
这里扩展一下权限拦截Filter的URL的一些说明

1、URL匹配规则

（1）“?”：匹配一个字符，如”/admin?”，将匹配“ /admin1”、“/admin2”，但不匹配“/admin”

（2）“”：匹配零个或多个字符串，如“/admin”，将匹配“ /admin”、“/admin123”，但不匹配“/admin/1”

（3）“”：匹配路径中的零个或多个路径，如“/admin/”，将匹配“/admin/a”、“/admin/a/b”

2、shiro过滤器

Filter解释anon无参，开放权限，可以理解为匿名用户或游客authc无参，需要认证logout无参，注销，执行后会直接跳转到shiroFilterFactoryBean.setLoginUrl(); 设置的 urlauthcBasic无参，表示 httpBasic 认证user无参，表示必须存在用户，当登入操作时不做检查ssl无参，表示安全的URL请求，协议为 httpsperms[user]参数可写多个，表示需要某个或某些权限才能通过，多个参数时写 perms["user, admin"]，当有多个参数时必须每个参数都通过才算通过roles[admin]参数可写多个，表示是某个或某些角色才能通过，多个参数时写 roles["admin，user"]，当有多个参数时必须每个参数都通过才算通过rest[user]根据请求的方法，相当于 perms[user:method]，其中 method 为 post，get，delete 等port[8081]当请求的URL端口不是8081时，跳转到schemal://serverName:8081?queryString 其中 schmal 是协议 http 或 https 等等，serverName 是你访问的 Host，8081 是 Port 端口，queryString 是你访问的 URL 里的 ? 后面的参数

常用的主要就是 anon，authc，user，roles，perms 等

注意：anon, authc, authcBasic, user 是第一组认证过滤器，perms, port, rest, roles, ssl 是第二组授权过滤器，要通过授权过滤器，就先要完成登陆认证操作（即先要完成认证才能前去寻找授权) 才能走第二组授权器（例如访问需要 roles 权限的 url，如果还没有登陆的话，会直接跳转到 shiroFilterFactoryBean.setLoginUrl(); 设置的 url ）。