-- Create table
create table user_info
(
  id              number(10) not null,
  username        varchar2(16) not null,
  password        varchar2(40) not null,
  mobile          varchar2(16),
  status          number(1) not null,
  register_time   timestamp not null,
  last_login_time timestamp,
  gender          char(1) not null,
  email           varchar2(36) not null
)
;
-- Add comments to the table 
comment on table user_info
  is '用户信息表';
-- Add comments to the columns 
comment on column user_info.id
  is '用户id';
comment on column user_info.username
  is '用户名';
comment on column user_info.password
  is '密码';
comment on column user_info.mobile
  is '手机号码';
comment on column user_info.status
  is '状态：0 正常 1禁用';
comment on column user_info.register_time
  is '注册时间';
comment on column user_info.last_login_time
  is '登录时间';
comment on column user_info.gender
  is '性别 female/male';
comment on column user_info.email
  is '邮箱';
-- Create/Recreate primary, unique and foreign key constraints 
alter table user_info
  add constraint username_unique_idx unique (USERNAME);
