package hello;

import java.util.function.Predicate;


public class HugeInteger {
	int[] digits;
	final int MAX_INT_LENGTH=40;
	HugeInteger()
	{
		digits = new int[MAX_INT_LENGTH];
		for(int i=0;i<MAX_INT_LENGTH;i++)
		{
			digits[i]=-1;
		}
	}
	
	
	HugeInteger(int[] indigits)
	{
		digits = new int[MAX_INT_LENGTH];
		for(int i=0;i<MAX_INT_LENGTH;i++)
		{
			digits[i]=indigits[i];
		}
	}
	
	public String toString()
	{
		String value="";
		int start=0;
		for(int i=MAX_INT_LENGTH-1;i>=0;i--)
		{
			if(start==0 && digits[i]!=0)
			{
				start=1;
			}
			if(start!=0)
			{
				value+=digits[i];
			}
		}
		return reverseString(value);
	}
	
	public String reverseString(String original)
	{
		 int length = original.length();
		 String reverse="";
	      for ( int i = length - 1 ; i >= 0 ; i-- )
	      {
	    	  reverse = reverse + original.charAt(i);
	      }
	      return reverse;
	}
	public int[] parse(String numbers)
	{
		numbers = numbers.trim();
		String values = reverseString(numbers);
		for(int i=0;i<MAX_INT_LENGTH;i++)
		{
			digits[i]=0;
		}
		for(int i=0;i<values.length();i++)
		{
			System.out.println(values.charAt(i));
			digits[i]=values.charAt(i)-'0';
		}
		return digits;
	}
	
	public int[] reverseDigits(int [] number)
	{
		
		 int reversedNumber [] = new int[MAX_INT_LENGTH]; 
		
	      for ( int i = MAX_INT_LENGTH -1 ; i >= 0 ; i-- )
	      {
	    	  
	    	  reversedNumber[i]= number [MAX_INT_LENGTH -i-1];
	    	  
	      }
	      return reversedNumber;
	}
	public boolean operation(HugeInteger number2, String Op)
	{
		HugeInteger number1 = new HugeInteger(reverseDigits(this.digits));
		number2 =  new HugeInteger(reverseDigits(number2.digits));
		
		
		
		Predicate<HugeInteger> isEqualTo = b -> {
			return number1.isEqualto(b);
		};
		Predicate<HugeInteger> isNotEqualTo = b -> {
			return number1.isNotEqualTo(b);
		};
		Predicate<HugeInteger> isGreaterThan = b -> {
			return number1.isGreaterThan(b);
		};
		Predicate<HugeInteger> isLessThan = b -> {
			return number1.isLessThan(b);
		};
		Predicate<HugeInteger> isGreaterThanOrEqualTo = b -> {
			return number1.isGreaterThanOrEqualTo(b);
		};
		Predicate<HugeInteger> isLessThanOrEqualTo = b -> {
			return number1.isLessThanOrEqualTo(b);
		};
		switch(Op)
		{
		case "isEqualto":
			return isEqualTo.test(number2);
		case "isNotEqualTo":
			return isNotEqualTo.test(number2);
		case "isGreaterThan":
			return isGreaterThan.test(number2);
		case "isLessThan":
			return isLessThan.test(number2);
		case "isGreaterThanOrEqualTo":
			return isGreaterThanOrEqualTo.test(number2);
		case "isLessThanOrEqualTo":
			return isLessThanOrEqualTo.test(number2);
		}
		return true;
	}
	public int[] add(HugeInteger second)
	{
		int[] result = new int[MAX_INT_LENGTH];
		System.out.println(" "+this.toString()+" + "+second.toString());
		int carry=0;
		for(int i=0;i<MAX_INT_LENGTH;i++)
		{
			result[i] = 0;
		}
		for(int i=0;i<40;i++)
		{
			int val=this.digits[i]+second.digits[i];
			result[i] = (val%10+carry)%10;
			carry = 0;
			if(val>10 || ((val%10+carry))>10)
			{
				carry=1;
			}
		}
		return result;
	}
	
	public int[] subtract(HugeInteger second)
	{
		int[] result = new int[MAX_INT_LENGTH];
		int carry=0;
		for(int i=0;i<MAX_INT_LENGTH;i++)
		{
			int val=this.digits[i] - (second.digits[i]+carry);
			if(val<0)
			{
				val = (this.digits[i]*10) - (second.digits[i]+carry);
				carry = 1;
			}
			result[i] = val;
		}
		return result;
	}
	
	public boolean isEqualto(HugeInteger second)
	{
		for(int i=0;i<MAX_INT_LENGTH;i++)
		{
			if(this.digits[i]!=second.digits[i])
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	
	public boolean isLessThan(HugeInteger second)
	{
		if(this.isNotEqualTo(second))
		{	
			for(int i=MAX_INT_LENGTH-1;i>=0;i--)
			{
				if(this.digits[i]>second.digits[i])
				{
					return false;
				}
			}
			return true;
		}		
		
		return false;
	}

	public boolean isGreaterThanOrEqualTo(HugeInteger second)
	{
		
		for(int i=MAX_INT_LENGTH-1;i>=0;i--)
		{
			if(this.digits[i]<second.digits[i])
			{
				return false;
			}
		}
		
		return true;
	}

	public boolean isNotEqualTo(HugeInteger second)
	{
		for(int i=0;i<MAX_INT_LENGTH;i++)
		{
			if(this.digits[i]!=second.digits[i])
			{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isGreaterThan(HugeInteger second)
	{
		
		for(int i=MAX_INT_LENGTH-1;i>=0;i--)
		{
			if(this.digits[i]<second.digits[i])
			{
				return false;
			}
		}
		
		return true;
	}
	public boolean isLessThanOrEqualTo(HugeInteger second)
	{
		for(int i=MAX_INT_LENGTH-1;i>=0;i--)
		{
			if(this.digits[i]>second.digits[i])
			{
				return false;
			}
		}
		
		return true;
	}
	
}
