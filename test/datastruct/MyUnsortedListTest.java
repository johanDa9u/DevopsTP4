package datastruct;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyUnsortedListTest {
	
	public MyUnsortedList<Integer> getList(Integer... elemements)
	{
		MyUnsortedList<Integer> list = MyUnsortedList.of(elemements);
		return list;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCreation()
	{
		assertEquals(0, getList().size());
		assertEquals(4,getList(1, 2, 3, 4).size());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(getList().isEmpty());
	}
	
	@Test
	public void testSize() {
		assertEquals(0,getList().size());
		assertEquals(3, getList(5, 2, 3).size());
	}
	
	@Test
	public void testPrepend()
	{
		MyUnsortedList list = getList(1, 2 , 3);
		list.prepend(0);
		assertEquals(0, list.pop());
	}
	
	@Test
	public void testAppend()
	{
		MyUnsortedList list = getList(1, 2, 3);
		list.append(0);
		assertEquals(0, list.popLast());
	}
	
	@Test
	public void testInsert()
	{
		MyUnsortedList list = getList(1, 2, 3);
		list.insert(0, 2);
		assertEquals(1, list.pop());
		assertEquals(2, list.pop());
		assertEquals(0, list.pop());
		assertEquals(3, list.pop());
	}
	
	@Test
	public void testInsertLast()
	{
		MyUnsortedList list = getList(1, 2, 3);
		list.insert(0, 3);
		assertEquals(0, list.popLast());
	}
	
	@Test
	public void testPop()
	{
		MyUnsortedList list = getList(1, 2, 3);
		assertEquals(1, list.pop());
		assertEquals(2, list.size());
	}
	
	@Test
	public void testRemove()
	{
		MyUnsortedList list = getList(1, 2, 3);
		assertEquals(3, list.remove(2));
		assertEquals(2, list.size());
	}
	
	@Test
	public void testPopLast()
	{
		MyUnsortedList list = getList(1, 2, 3);
		assertEquals(3, list.popLast());
		assertEquals(2, list.size());
	}
	
	@Test
	public void testEquals()
	{
		MyUnsortedList list = getList(1, 2, 3);
		MyUnsortedList list2 = getList(1, 2, 3);
		MyUnsortedList listVide1 = getList();
		MyUnsortedList listVide2 = getList();
		MyUnsortedList listWrong = getList(1, 2, 3, 4);
		MyUnsortedList listWrong2 = getList(1, 2, 4);
		
		assertTrue(list.equals(list2));				
		assertTrue(list2.equals(list));			
		assertTrue(listVide1.equals(listVide2));	
		
		assertTrue(!list.equals(listWrong));
		assertTrue(!list.equals(listWrong2));
	}
}
