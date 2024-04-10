set global time_zone = "Asia/Tokyo";

-- --------------------------------------------------------

--
-- Table structure for database(EGG_CODER)
--

drop database if exists egg_coder;
create database egg_coder
  default character set utf8mb4
  default collate utf8mb4_unicode_ci;
set default_storage_engine = InnoDB;

use egg_coder;

-- ユーザー
drop table if exists `USERS`;
create table `USERS`
(
    `id_user`        varchar(50)  not null primary key,
    `name`           varchar(255) not null,
    `created_at`     timestamp    not null default current_timestamp,
    `created_by`     varchar(255) not null,
    `updated_at`     timestamp    not null default current_timestamp,
    `updated_by`     varchar(255) not null,
    `deleted_at`     timestamp             default null
);

-- 記録
drop table if exists `RECORDS`;
create table `RECORDS`
(
    `id_record`      varchar(50)    not null primary key,
    `title`          varchar(255)   not null,
    `question`       TEXT           not null,
    `user_answer`    TEXT,
    `model_answer`   TEXT,
    `review_flag`    TINYINT(1)     not null default 0,
    `comment`        TEXT,
    `created_at`     timestamp      not null default current_timestamp,
    `created_by`     varchar(255)   not null,
    `updated_at`     timestamp      not null default current_timestamp,
    `updated_by`     varchar(255)   not null,
    `deleted_at`     timestamp               default null
);

-- タグ
drop table if exists `TAGS`;
create table `TAGS`
(
    `id_tag`         varchar(50)    not null primary key,
    `id_user`        varchar(50)    not null,
    `name`           varchar(255)   not null,
    `color_code`     varchar(6)     not null,
    `created_at`     timestamp      not null default current_timestamp,
    `created_by`     varchar(255)   not null,
    `updated_at`     timestamp      not null default current_timestamp,
    `updated_by`     varchar(255)   not null,
    `deleted_at`     timestamp               default null
);

-- タグと記録のマッピングテーブル
drop table if exists `TAG_RECORDS`;
create table `TAG_RECORDS`
(
    `id_record`      varchar(50)    not null,
    `id_tag_json`    JSON           not null,
    `created_at`     timestamp      not null default current_timestamp,
    `created_by`     varchar(255)   not null,
    `updated_at`     timestamp      not null default current_timestamp,
    `updated_by`     varchar(255)   not null,
    `deleted_at`     timestamp               default null
);

-- ログイン情報
drop table if exists `LOGIN_AUTHORITIES`;
create table `LOGIN_AUTHORITIES`
(
    `id_login_authority`   varchar(50)    not null primary key,
    `id_user`              varchar(50)    not null,
    `email`                varchar(100)   not null,
    `password`             varchar(100)   not null,
    `created_at`           timestamp      not null default current_timestamp,
    `created_by`           varchar(255)   not null,
    `updated_at`           timestamp      not null default current_timestamp,
    `updated_by`           varchar(255)   not null,
    `deleted_at`           timestamp               default null
);

