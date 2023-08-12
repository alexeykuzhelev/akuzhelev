create or replace function f_insert_data(i_name varchar, prod varchar, i_count integer, i_price integer)
    returns void
    language 'plpgsql'
as
$$
    begin
        insert into products (name, producer, count, price)
        values (i_name, prod, i_count, i_price);
    end;
$$;

create or replace procedure delete_data_by_id(d_id integer)
    language 'plpgsql'
as
$$
    begin
        delete from products where id = d_id;
    end;
$$;

create or replace function f_delete_data_by_count(d_count integer)
    returns integer
    language 'plpgsql'
as
$$
    declare
        result_count integer;
    begin
        select into result_count sum(count) from products where count <= d_count;
        delete from products where count >= d_count;
        return result_count;
    end;
$$;

delete from products;
ALTER SEQUENCE products_id_seq RESTART WITH 1;

select f_insert_data('product_1', 'producer_1', 25, 50);
select f_insert_data('product_2', 'producer_2', 15, 32);
select f_insert_data('product_3', 'producer_3', 8, 115);

call delete_data_by_id(1);
select f_delete_data_by_count(17);
