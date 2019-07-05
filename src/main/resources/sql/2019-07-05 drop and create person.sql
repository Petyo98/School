DROP TABLE IF EXISTS public.Person;
DROP TABLE IF EXISTS public.person;

CREATE TABLE public.person
(
  id bigint NOT NULL,
  created_date timestamp without time zone,
  updated_date timestamp without time zone,
  fisrt_name character varying(55),
  last_name character varying(55),
  second_name character varying(55),
  CONSTRAINT person_pkey PRIMARY KEY (id)
)