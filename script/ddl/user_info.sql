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
  is '�û���Ϣ��';
-- Add comments to the columns 
comment on column user_info.id
  is '�û�id';
comment on column user_info.username
  is '�û���';
comment on column user_info.password
  is '����';
comment on column user_info.mobile
  is '�ֻ�����';
comment on column user_info.status
  is '״̬��0 ���� 1����';
comment on column user_info.register_time
  is 'ע��ʱ��';
comment on column user_info.last_login_time
  is '��¼ʱ��';
comment on column user_info.gender
  is '�Ա� female/male';
comment on column user_info.email
  is '����';
-- Create/Recreate primary, unique and foreign key constraints 
alter table user_info
  add constraint username_unique_idx unique (USERNAME);
