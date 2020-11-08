package com.rotterdam.beyondhoop.models

import slick.jdbc.PostgresProfile.api._

case class Topic(
                  name: String,
                  description: String, //The description of the topic
                  group_count: Int, //The number of groups using this topic
                  lang: String, //Language topic originates from
                  member_count: Int //The number of members interested in this topic
                )

class TopicRecord(tag: Tag) extends
  Table[(Int, String, String, Int, String, Int)](tag, "topic") {

  def id = column[Int]("id")
  def name = column[String]("name")
  def description = column[String]("description")
  def group_count = column[Int]("group_count")
  def lang = column[String]("lang")
  def member_count = column[Int]("member_count")

  def * = (id, name, description, group_count, lang, member_count)
}

/*
docker run -v beyond_postgres_volume:/var/lib/postgresql/data --name volume-postgres -p 5433:5432 -d bsio/postgres:version1

CREATE DATABASE beyond_meetup

CREATE TABLE topic
(
  id bigserial NOT NULL,
  name text,
  description text,
  group_count integer, -- https://www.postgresql.org/docs/10/datatype-numeric.html
  lang text,
  member_count text,
  CONSTRAINT pk PRIMARY KEY (id)
)

INSERT INTO topic(name, description, group_count, lang, member_count) VALUES
('Sports', 'a place to stay in shape', 3, 'english', 200),
('Politics', 'elections are difficult', 56, 'english', 100),
('Porn', 'pass time during Covid', 10, 'english', 10000)

 */
